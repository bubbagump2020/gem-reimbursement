package com.gem.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.gem.models.ReimbursementRequest;
import com.gem.util.ConnUtil;

public class ReimbursementDao implements DaoContract<ReimbursementRequest, Integer> {

	@Override
	public List<ReimbursementRequest> findAll() {
		List<ReimbursementRequest> reimbursements = new LinkedList<>();
		try(Connection conn = ConnUtil.getInstance().getConnection()){
			String query = "select * from all_reimbursements";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				reimbursements.add(
							new ReimbursementRequest(
										rs.getInt(1), //id
										rs.getInt(2), // amount
										rs.getDate(3), // submitted
										rs.getDate(4), // resolved
										rs.getString(5),
										rs.getInt(6), //description
										rs.getString(8), //status
										rs.getString(9) //type
									)
						);
			}
			rs.close();
			ps.close();
		}catch(SQLException e) {
			
		}
		return reimbursements;
	}
	
	public List<ReimbursementRequest> findByUserId(int userId){
		List<ReimbursementRequest> reimbursements = new LinkedList<>();
		try(Connection conn = ConnUtil.getInstance().getConnection()){
			String query = "select * from all_reimbursements where dwarf_miner = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, userId);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				reimbursements.add(
							new ReimbursementRequest(
										rs.getInt(1), //id
										rs.getInt(2), // amount
										rs.getDate(3), // submitted
										rs.getDate(4), // resolved
										rs.getString(5),
										rs.getInt(6), //description
										rs.getString(8), //status
										rs.getString(9) //type
									)
						);
			}
			rs.close();
			ps.close();
		}catch(SQLException e) {
			
		}
//		System.out.println(reimbursements);
		return reimbursements;
	}

	@Override
	public ReimbursementRequest findById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int update(ReimbursementRequest rr) {
		Date resolvedDate = (Date) rr.getResolved();
		int result = 0;
		int status = 1;
		switch(rr.getStatus()) {
			case "Approve":
				System.out.println("Accepted!");
				status=2;
				break;
			case "Reject":
				System.out.println("Rejected!");
				status=3;
				break;
		}
		try(Connection conn = ConnUtil.getInstance().getConnection()){
			String query = "call update_reimbursement(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDate(1, (java.sql.Date) resolvedDate);
			ps.setInt(2, rr.getDwarfOverseerId());
			ps.setInt(3, status);
			ps.setInt(4, rr.getId());
			result = ps.executeUpdate();
			ps.close();
		} catch(SQLException e) {}
		return result;
}

	@Override
	public int create(ReimbursementRequest t) {
		Date submittedDate = (Date) t.getSubmitted();
		int result = 1;
		int type = 0;
		switch(t.getType()) {
			case "GEMSTONES":
				type=1;
				break;
			case "METAL":
				type=2;
				break;
			case "STONE":
				type=3;
				break;
			case "TROPHY":
				type=4;
				break;
			case "DIRT":
				type=5;
				break;
		}
		try(Connection conn = ConnUtil.getInstance().getConnection()){
			String query = "insert into reimbursement_request (amount, submitted, description, dwarf_miner, reimburse_type, reimburse_status) values (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, t.getAmount());
			ps.setDate(2, (java.sql.Date) submittedDate);
			ps.setString(3, t.getDescription());
			ps.setInt(4, t.getDwarfMinerId());
			ps.setInt(5, type);
			ps.setInt(6, 1);
			result = ps.executeUpdate();
			ps.close();
		} catch(SQLException e) {}
		return result;
	}

	@Override
	public int delete(Integer i) {
		// TODO Auto-generated method stub
		return 0;
	}

}

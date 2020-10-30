package com.gem.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.gem.models.Dwarf;
import com.gem.util.ConnUtil;

public class DwarfDao implements DaoContract<Dwarf, Integer> {

	@Override
	// find all dwarves for the overseer
	public List<Dwarf> findAll() {
		List<Dwarf> allDwarves = new LinkedList<>();
		try(Connection conn = ConnUtil.getInstance().getConnection()){
			String query = "select * from login_dwarf;";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				allDwarves.add(
					new Dwarf(
						rs.getInt("id"),
						rs.getString("email"),
						rs.getString("cryptpwd"),
						rs.getString("username"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("role_type")
					)
				);
			}
			ps.close();
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return allDwarves;
	}
	// login method
	public Dwarf findByUsernamePassword(Dwarf d) {
		Dwarf loggedInDwarf = null;
		try(Connection conn = ConnUtil.getInstance().getConnection()){
			String query = "select * from login_dwarf where email=? and cryptpwd=(crypt(?, cryptpwd));";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, d.getEmail());
			ps.setString(2, d.getPassword());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				loggedInDwarf = new Dwarf(
						rs.getInt("id"),
						rs.getString("email"),
						rs.getString("cryptpwd"),
						rs.getString("username"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("role_type")
					);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return loggedInDwarf;
	}
	
	// updating a dwarf
	public int updateDwarf(Dwarf d) {
		int dbResponse = 0;
		try(Connection conn = ConnUtil.getInstance().getConnection()){
			String query = "update dwarf set first_name=?, last_name=? where email=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, d.getFirstName());
			ps.setString(2, d.getLastName());
			ps.setString(3, d.getEmail());
			dbResponse = ps.executeUpdate();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return dbResponse;
	}

	@Override
	// might not need this
	public Dwarf findById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	// account creation
	public int create(Dwarf t) {
		int result = 1;
		try(Connection conn = ConnUtil.getInstance().getConnection()){
			String query = "call create_dwarf (?,?,?,?);";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getEmail());
			ps.setString(2, t.getPassword());
			ps.setString(3, t.getUsername());
			ps.setInt(4, 2);
			result = ps.executeUpdate();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(Integer i) {
		// TODO Auto-generated method stub
		return 0;
	}

}

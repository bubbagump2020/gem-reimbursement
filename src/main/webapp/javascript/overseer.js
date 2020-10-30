function renderTable(reimbursement){
    const approveOrDeny = async (event) => {
        const approvedOrDenied = {
            id: parseInt(event.target.id),
            status: event.target.innerHTML
        }
        const response = await fetch("http://localhost:8081/Gem/update_reimbursement.json", {
            method: "put",
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            },
            body: JSON.stringify(approvedOrDenied)
        })
        window.location.reload();
    }
    let tableBody = document.getElementById('reimbursementTableBody');
    const row = document.createElement('tr')
            const approveButton = document.createElement('button');
            approveButton.innerHTML = "Approve";
            approveButton.setAttribute("id", `${reimbursement.id}`)
            approveButton.setAttribute("class", "btn btn-success pull-left");
            approveButton.addEventListener('click', approveOrDeny)
            const deniedButton = document.createElement('button')
            deniedButton.innerHTML = "Reject";
            deniedButton.setAttribute("id", `${reimbursement.id}`)
            deniedButton.setAttribute("class", "btn btn-danger pull-right");
            deniedButton.setAttribute("style", "margin-left: 15px");
            deniedButton.addEventListener('click', approveOrDeny)
            const amountCell = document.createElement('td');
            amountCell.innerHTML = reimbursement.amount;
            const descriptionCell = document.createElement('td');
            descriptionCell.innerHTML = reimbursement.description;
            const submittedCell = document.createElement('td');
            submittedCell.innerHTML = new Date(reimbursement.submitted);
            const resolvedCell = document.createElement('td');
            if(reimbursement.resolved == null){
                resolvedCell.innerHTML = "Pending";
            } else {
                resolvedCell.innerHTML = new Date(reimbursement.resolved);
            }
            const typeCell = document.createElement('td');
            typeCell.innerHTML = reimbursement.type;
            const statusCell = document.createElement('td')
            statusCell.innerHTML = reimbursement.status;
            const buttonSpan = document.createElement('span')
            buttonSpan.setAttribute("class", "btn-seperator")
            row.append(amountCell);
            row.append(descriptionCell)
            row.append(submittedCell);
            row.append(resolvedCell);
            row.append(typeCell);
            row.append(statusCell);
            if(statusCell.innerHTML == "PENDING"){
                row.append(approveButton);
                row.append(deniedButton);
            }
            tableBody.appendChild(row);
}

async function getReimbursementsOnWindowLoad(){
    const response = await fetch("http://localhost:8081/Gem/all_reimbursements.json")
    if(response.status === 200){
        const data = await response.json();
        console.log(data)
        data.map(element => {
            renderTable(element);
        })
    } else {
        console.log('something went wrong')
    }
}

window.addEventListener('load', getReimbursementsOnWindowLoad);



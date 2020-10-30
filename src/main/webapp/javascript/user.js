/**
 * user page related js functions
 */
//make table

console.log('connected');

//on Window load, bring back my reimbursements

function renderTable(reimbursement){
    let tableBody = document.getElementById('reimbursementTableBody');
    const row = document.createElement('tr')
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
            row.append(amountCell);
            row.append(descriptionCell)
            row.append(submittedCell);
            row.append(resolvedCell);
            row.append(typeCell);
            row.append(statusCell);
            tableBody.appendChild(row);
}

async function getReimbursementsOnWindowLoad(){
    const response = await fetch("http://3.138.155.76:8081/user_reimbursements.json")
    if(response.status === 200){
        const data = await response.json();
        data.map(element => {
            renderTable(element);
        })
    }
}

window.addEventListener('load', getReimbursementsOnWindowLoad);

// submitting a reimbursement
async function handleSubmit(event){
    const reimbursement = {
        amount: parseInt(document.getElementById('amount').value),
        description: document.getElementById('description').value,
        type: document.getElementById('materials').value
    }
    console.log(reimbursement)
    const response = await fetch("http://localhost:8081/Gem/reimbursement.json", {
        method: 'post',
        headers: {
            'X-Requested-With': 'XmlHttpRequest',
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        },
        body: JSON.stringify(reimbursement)
    })
}

document.getElementById('reimbursementForm').addEventListener('submit', handleSubmit);

function handleLogout(){
    // document.cookie="expres=Thu, 01 Jan 1970 00:00:00 UTC";
    // console.log(cookie);
}

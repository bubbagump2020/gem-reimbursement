/**
 * 
 */

console.log('connected');

async function handleLoginSubmit(e){
	e.preventDefault();
	const dwarf = {
		email: document.getElementById('loginEmail').value,
		password: document.getElementById('loginPassword').value
	}
	let response = await fetch('http://3.138.155.76:8081/login.page', {
		method: 'post',
		headers: {
			'X-Requested-With': 'XmlHttpRequest',
			'Content-Type': 'application/json',
			'Accept': 'application/json'
		},
		body: JSON.stringify(dwarf)
	});
	console.log(response)
	if(response.status === 200){
		let data = await response.json();
		console.log(data)
		localStorage.setItem('user', JSON.stringify(data));
		// window.location.href = 'http://localhost:8081/Gem/html/user.html'
	} else {
		const failure = document.createElement('p');
		failure.innerHTML='failed to login'
	}
}

document.getElementById('loginForm').addEventListener('submit', handleLoginSubmit);

async function handleCreateSubmit(){
	const dwarf = {
		email: document.getElementById('createEmail').value,
		username: document.getElementById('createUsername').value,
		password: document.getElementById('createPassword')
	}
	const response = await fetch('http://3.138.155.76:8081/create-dwarf.json', {
		method: 'put',
		headers: {
			'X-Requested-With': 'XmlHttpRequest',
			'Content-Type': 'application/json',
			'Accept': 'application/json'
		},
		
		body: JSON.stringify(dwarf)
	})
	console.log(response)
	if(response.status === 200){
		const data = await response.json();
		localStorage.setItem('user', JSON.stringify(data))
	} else {
		const failure = document.createElement('p');
		failure.innerHTML='failed to login'
	}
}

// document.getElementById('createForm').addEventListener('submit', handleCreateSubmit);
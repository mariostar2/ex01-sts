/**
 * 
 */


//조회
function select(){
	fetch("/index/test01")
	.then(response =>response.json())
	.then(result =>{
		console.log(result)
		let html ="";
		result.forEach(item =>{
			
			html += `<p>아이디 :`+ item.id  + `비밀번호 :` + item.pw + `</p>`;
		});
		document.getElementById("result").innerHTML = html;	
	})
}


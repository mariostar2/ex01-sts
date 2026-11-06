/**
 * 
 */

function test0Run() {
    fetch("/ajax/test0")
        //.then(response => response.text())
        .then(response => response.json())
        .then(data => document.getElementById("test0").textContent = data.writer);
}
function test1Run() {
    //1. 입력 양식에 있는 데이터 가져오기
    const writer = document.getElementById("writer").value; //Ann
    const message = document.getElementById("message").value; //Good!

    //2. 데이터를 파라미터로 만들어 서버에 fetch 요청하기
    fetch("/ajax/test1?writer=" + writer + "&message=" + message) //요청
        .then(response => response.json())//응답 1단계
        .then(data => //응답 2단계 
            document.getElementById("test1").textContent = data.writer);
}

function test2Run() {
    const form = document.getElementById("frm");
    const formData = new FormData(form);

    fetch("/ajax/test2", {
        method: "POST",
        body: formData
    })//요청 (서버주소,데이터)
        .then(response => response.json())
        .then(result => document.getElementById("test2").textContent = result.writer);
}


function test3Run() {
	//const author = document.getElementById("author").value;
	//const msg = document.getElementById("msg").value;
    //1. 객체 만들기
    const obj = {
        writer: "Hong",
        message: "Best!",
		};
    //2. fetch로 서버에 객체 보내기
    fetch("/ajax/test3", {
        method :"POST",
		headers : {
			"Content-Type" : "application/json"
		},
		body: JSON.stringify(obj)
    })
	//서버를 받은걸로 돌려주는것
	.then(response => response.json())
	.then(result => document.getElementById("test3").textContent = result.writer);
		
}


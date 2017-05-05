/**
 * 
 */
function checkemail(){
	

	// 获取标签

	var uemail = document.getElementsByName("email");
	var emailtip = document.getElementById("emailtip");
	// 获取标签中的值
	var emailvalue = uemail[0].value;
	// 用正则表达式匹配
	var reg = /\w+@.+\.\w+/i;
	// 先设置下一个标签值为空
	emailtip.childNodes[1].innerText= "";
	console.log();
	if (!reg.test(emailvalue)) {
		emailtip.childNodes[1].innerText = "请输入正确的邮箱地址";
		console.log(emailtip.childNodes[1]);
		return false;
	}
	return true;
}
function checkname() {
	var uname = document.getElementsByName("username");
	var namevalue = uname[0].value;
	var reg = /^[a-z][a-z0-9]{5}$/i;
	uname[0].nextSibling.innerText = "";
	if (!reg.test(namevalue)) {
		uname[0].nextSibling.innerText = "用户名是6位字母和数字的组合，不能由数字开头";
		return false;
	}
	return true;
}

function checkpwd() {
	var pwd = document.getElementById("password");
	var pwdvalue = pwd.value;
	reg = /^[a-zA-Z]\w{5,17}$/; // 以字母开头，长度在6~18之间，只能包含字符、数字和下划线
	pwd.nextSibling.innerText = "";
	if (!reg.test(pwdvalue)) {
		pwd.nextSibling.innerText = "密码以字母开头，长度在6~18之间，只能包含字符、数字和下划线";
		return false;
	}
	return true;
}

function checkrepwd() {
	var repwd = document.getElementById("repasswd");
	var repwdvalue = repwd.value;
	var pwd = document.getElementById("password");
	var pwdvalue = pwd.value;
	repwd.nextSibling.innerText = "";
	if (pwdvalue != repwdvalue) {
		repwd.nextSibling.innerText = "请输入一致的密码";
		return false;
	}
	return true;
}
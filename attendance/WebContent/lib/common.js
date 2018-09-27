/*日期格式转换 毫秒转换成日期(包含时分秒)*/
function transDate(millSec) {
	var date = new Date(millSec);
	var str = "";
	str = str + date.getFullYear() + "-";
	str = str + (date.getMonth() + 1) + "-";
	str = str + date.getDate() + " ";
	str = str + date.getHours() + ":";
	str = str + date.getMinutes() + ":";
	str = str + date.getSeconds();
	return str;
}

/*日期格式转换 毫秒转换成日期(不包含时分秒)*/
function transDateOnlyDay(millSec) {
	var date = new Date(millSec);
	var str = "";
	str = str + date.getFullYear() + "-";
	str = str + (date.getMonth() + 1) + "-";
	str = str + date.getDate();
	return str;
}

/*根据出生日期计算出用户年龄*/
function getAge(millSec) {
	var curDate = new Date();
	var birthday = new Date(millSec);
	return curDate.getFullYear() - birthday.getFullYear() + 1;
}

/*验证日期格式是否满足 yyyy-mm-dd*/
function isdate(str) {
    var result = str.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);
    if (result == null) return false;
    var d = new Date(result[1], result[3] - 1, result[4]);
    return (d.getFullYear() == result[1] && d.getMonth() + 1 == result[3] && d.getDate() == result[4]);
}

/*验证固话*/
function validatePhone(phone) {
	var reg = /^0[0-9]{2,3}-[0-9]{7,8}$/;
	if (!reg.test(phone)) {
        return false;
    } else {
        return true;
    }
}

/*验证移动*/
function validateMobile(mobile) {
	 var reg=/^[1][3,4,5,7,8][0-9]{9}$/;
     if (!reg.test(mobile)) {
         return false;
     } else {
         return true;
     }
}

/*验证邮箱*/
function validateEmail(email) {
	var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/; 
	if (!reg.test(email)) {
        return false;
    } else {
        return true;
    }
}

var context;
var d;
var str;
function getClock() {

	d = new Date();
	str = Calculate(d.getHours(), d.getMinutes(), d.getSeconds());

	context = clock.getContext("2d");
	context.clearRect(0, 20, 500, 200);
	context.font = "40pt calibri";
	context.fillStyle = "white";
	context.fillText(str, 102, 125);
}

function Calculate(hour, min, sec) {
	var curTime;
	if (hour < 10)
		curTime = "0" + hour.toString();
	else
		curTime = hour.toString();

	if (min < 10)
		curTime += ":0" + min.toString();
	else
		curTime += ":" + min.toString();

	if (sec < 10)
		curTime += ":0" + sec.toString();
	else
		curTime += ":" + sec.toString();
	return curTime;
}

setInterval(getClock, 1000);


function startTime() {
    var today=new Date();
    var h=today.getHours();
    var m=today.getMinutes();
    var s=today.getSeconds();
    // add a zero in front of numbers<10
    m=checkTime(m);
    s=checkTime(s);
    document.getElementById('txt').innerHTML=h+":"+m+":"+s;
    t=setTimeout('startTime()',500);
}

function checkTime(i){
if (i<10) {
    i="0" + i;
}
    return i;
}

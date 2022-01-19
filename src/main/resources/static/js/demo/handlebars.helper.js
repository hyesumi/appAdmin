

Handlebars.registerHelper('position', function() {
    return window.positionCounter--;
});


Handlebars.registerHelper('getOsType', function(v) {

    var osType = "";

    if( v == '10'){
        osType = "Android";
    }else{
        osType = "IOS";
    }
    return osType;
});


Handlebars.registerHelper('getStatus', function(v) {

    var status = "";

    if( v == '01'){
        status = "사용";
    }else{
        status = "미사용";
    }
    return status;

});




Handlebars.registerHelper('getEventCode', function(v) {

    var eventCode = '';

    switch(v){
        case '00' :
            eventCode = '설정변경';
        break;
        case '01' :
            eventCode = '충격';
            break;
        case '02' :
            eventCode = 'Power OFF';
            break;
        case '03' :
          eventCode = '저전압';
        break;
        case '04' :
         eventCode = '인증완료';
        break;
        case '05' :
          eventCode = '시동ON';
        break;
        case '06' :
          eventCode = '시동OFF';
        break;
        case '10' :
          eventCode = 'Power On';
        break;
        default :
            eventCode = '없음';
    }

    return eventCode;

});


/**
 * {{@index}} 0 부터 시작 하기 때문에 1부터 시작 하도록 +1 처리 
 * @param value
 * @returns
 */
Handlebars.registerHelper('increase', function(value) {
	return parseInt(value) +1;
});

Handlebars.registerHelper('sum', function(value) {
	window.sumUserCnt = Number(window.sumUserCnt) + Number(value);
//	console.log(Number(window.sumUserCnt) + Number(value));
	return window.sumUserCnt;
});


Handlebars.registerHelper('getValue', function(value) {
//	console.log(value);s
	if( value != null && value != undefined && value != ''){
		return value.join(",");	
	}else{
		return " - ";
	}
	
});

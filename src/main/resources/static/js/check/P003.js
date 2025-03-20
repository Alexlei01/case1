// VueCheckJS.vm

/* dynamic define function end */

/* btn check end */

function DoMustCheck(){
    for (let i=1; ;i++) {
	let elm = getObj("rowgrid2" + i)
	if(!elm || $(elm).attr("gridOpFlag") == 0) break
	}

    eval(SF.getMustCheckData());
    if (!SF.isCheckSuccess()) {
          alert(jQuery.i18n.prop("com.msg_1000803"));
        SF.setCheckSuccess(true);
        return false;
    }
    return true;
}

function DoDataCheck() {
    var alertMsg = "";
    for (let i=1; ;i++) {
	let elm = getObj("rowgrid2" + i)
	if(!elm || $(elm).attr("gridOpFlag") == 0) break
 		if(!checkIntegerType(getObj('id' + i), "id", true, "項目「@@」には数値を入力して下さい。")) { alertMsg += '' + i +'行目の[id]項目に入力できるのは[数字+[-]]のみです。#n#'; } 		if(!isLenCheck(getObj('emailtitle' + i), 1000, "メールタイトル", true)) { alertMsg += '' + i +'行目の[メールタイトル]項目に入力できるのは[最大長さは1000の値]のみです。#n#'; } 		if(!isLenCheck(getObj('emailsender' + i), 255, "送信者", true)) { alertMsg += '' + i +'行目の[送信者]項目に入力できるのは[最大長さは255の値]のみです。#n#'; } 		if(!isDateTime(getObj('emailsendtime' + i), false, "メール送信時刻", true)) { alertMsg += '' + i +'行目の[メール送信時刻]項目に入力できるのは[日時]のみです。#n#'; }	}

	 if(!isDate(getObj("interviewtimestart"),false,"面接可能時間",true,true)) { alertMsg += '[面接可能時間]項目に入力できるのは[日付]のみです。#n#';SF.setCheckSuccess(false); }
	 if(!isDate(getObj("interviewtimeend"),false,"面接可能時間",true,true)) { alertMsg += '[面接可能時間]項目に入力できるのは[日付]のみです。#n#';SF.setCheckSuccess(false); }
	 if(!isDate(getObj("emailsendtimestart"),false,"メール送信時刻",true,true)) { alertMsg += '[メール送信時刻]項目に入力できるのは[日付]のみです。#n#';SF.setCheckSuccess(false); }
	 if(!isDate(getObj("emailsendtimeend"),false,"メール送信時刻",true,true)) { alertMsg += '[メール送信時刻]項目に入力できるのは[日付]のみです。#n#';SF.setCheckSuccess(false); }
	 if(!isDate(getObj("entrytimestart"),false,"入場可能時間",true,true)) { alertMsg += '[入場可能時間]項目に入力できるのは[日付]のみです。#n#';SF.setCheckSuccess(false); }
	 if(!isDate(getObj("entrytimeend"),false,"入場可能時間",true,true)) { alertMsg += '[入場可能時間]項目に入力できるのは[日付]のみです。#n#';SF.setCheckSuccess(false); }
    eval(SF.getItemCheckData());
    if (alertMsg != "") {
        alertMsg = alertMsg.replace(/#n#/g, '\n').trim();
        alert(alertMsg);
        SF.setCheckSuccess(true);
        return false;
    }
    return true;
}
function DoBeforeSave() {
      if (''=='') {
        return true;
    } else {
      return ;
    }
}

function doLinkTrans9(o){ SF.setServerExecute(true);
}

function inputDataCheck(){
    $(".ErrStyle").each(function () {
        var _this = $(this);
        var parentObj = _this.parent(".WF_STABLE_CLASS_TH , .WF_STABLE_CLASS_TD");
        var isStaticTableItem = (parentObj.length > 0);
        _this.removeClass("ErrStyle");
        if (isStaticTableItem) {
            parentObj.css("background-color", "");
        }
    });
    if (popErrCheck()) {
        if(DoMustCheck())
            if (DoDataCheck())
                return DoBeforeSave();
            else
                return false;
        else
            return false;
    } else {
        return false;
    }
}
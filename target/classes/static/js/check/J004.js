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
 		if(!checkIntegerType(getObj('id' + i), "id", true, "項目「@@」には数値を入力して下さい。")) { alertMsg += '' + i +'行目の[id]項目に入力できるのは[数字+[-]]のみです。#n#'; } 		if(!isLenCheck(getObj('recruitment' + i), 100, "募集要員", true)) { alertMsg += '' + i +'行目の[募集要員]項目に入力できるのは[最大長さは100の値]のみです。#n#'; } 		if(!isLenCheck(getObj('emailsender' + i), 255, "送信者", true)) { alertMsg += '' + i +'行目の[送信者]項目に入力できるのは[最大長さは255の値]のみです。#n#'; } 		if(!isLenCheck(getObj('emailsendtime' + i), 30, "メール送信時刻", true)) { alertMsg += '' + i +'行目の[メール送信時刻]項目に入力できるのは[最大長さは30の値]のみです。#n#'; }	}

	 if(!isDate(getObj("emailsendtimestart"),false,"メール送信時刻",true,true)) { alertMsg += '[メール送信時刻]項目に入力できるのは[日付]のみです。#n#';SF.setCheckSuccess(false); }
	 if(!isDate(getObj("emailsendtimeend"),false,"メール送信時刻",true,true)) { alertMsg += '[メール送信時刻]項目に入力できるのは[日付]のみです。#n#';SF.setCheckSuccess(false); }
	 if(!isDate(getObj("projectcyclestart"),false,"予定開始日",true,true)) { alertMsg += '[予定開始日]項目に入力できるのは[日付]のみです。#n#';SF.setCheckSuccess(false); }
	 if(!isDate(getObj("projectcycleend"),false,"予定開始日",true,true)) { alertMsg += '[予定開始日]項目に入力できるのは[日付]のみです。#n#';SF.setCheckSuccess(false); }
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

	pageLinkTranfer("L00003.do?","1",o,"id,","id,","_self","","0","","");
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
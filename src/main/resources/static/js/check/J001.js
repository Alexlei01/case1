// VueCheckJS.vm

/* dynamic define function end */

/* btn check end */

function DoMustCheck(){
    if (!checkRequired(getObj('txt2'),'id',true,'項目「@@」が空白になっています。', true)) {SF.setCheckSuccess(false);}

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
    
	 if(!checkIntegerType(getObj("txt2"),"id",true,false)) { alertMsg += '[id]項目に入力できるのは[数字+[-]]のみです。#n#'; return false; }
	 if(getObj("project")) {
	 if(!isLenMaxCheck(getObj("project"),255,"項目",true,false)) { alertMsg += '[項目]項目に入力できるのは[最大長さは255の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("project"),255,"項目",true,true)) { alertMsg += '[項目]項目に入力できるのは[最大長さは255の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(getObj("outline")) {
	 if(!isLenMaxCheck(getObj("outline"),255,"概要",true,false)) { alertMsg += '[概要]項目に入力できるのは[最大長さは255の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("outline"),255,"概要",true,true)) { alertMsg += '[概要]項目に入力できるのは[最大長さは255の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(getObj("projectmachine")) {
	 if(!isLenMaxCheck(getObj("projectmachine"),255,"機種",true,false)) { alertMsg += '[機種]項目に入力できるのは[最大長さは255の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("projectmachine"),255,"機種",true,true)) { alertMsg += '[機種]項目に入力できるのは[最大長さは255の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(getObj("recruitment")) {
	 if(!isLenMaxCheck(getObj("recruitment"),100,"募集要員",true,false)) { alertMsg += '[募集要員]項目に入力できるのは[最大長さは100の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("recruitment"),100,"募集要員",true,true)) { alertMsg += '[募集要員]項目に入力できるのは[最大長さは100の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(getObj("projectcycle")) {
	 if(!isLenMaxCheck(getObj("projectcycle"),250,"予定開始日",true,false)) { alertMsg += '[予定開始日]項目に入力できるのは[最大長さは250の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("projectcycle"),250,"予定開始日",true,true)) { alertMsg += '[予定開始日]項目に入力できるのは[最大長さは250の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(getObj("workaddress")) {
	 if(!isLenMaxCheck(getObj("workaddress"),255,"勤務先アドレス",true,false)) { alertMsg += '[勤務先アドレス]項目に入力できるのは[最大長さは255の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("workaddress"),255,"勤務先アドレス",true,true)) { alertMsg += '[勤務先アドレス]項目に入力できるのは[最大長さは255の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(getObj("budget")) {
	 if(!isLenMaxCheck(getObj("budget"),100,"予算",true,false)) { alertMsg += '[予算]項目に入力できるのは[最大長さは100の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("budget"),100,"予算",true,true)) { alertMsg += '[予算]項目に入力できるのは[最大長さは100の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(getObj("emailsender")) {
	 if(!isLenMaxCheck(getObj("emailsender"),255,"送信者",true,false)) { alertMsg += '[送信者]項目に入力できるのは[最大長さは255の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("emailsender"),255,"送信者",true,true)) { alertMsg += '[送信者]項目に入力できるのは[最大長さは255の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(getObj("emailsendtime")) {
	 if(!isLenMaxCheck(getObj("emailsendtime"),30,"メール送信時刻",true,false)) { alertMsg += '[メール送信時刻]項目に入力できるのは[最大長さは30の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("emailsendtime"),30,"メール送信時刻",true,true)) { alertMsg += '[メール送信時刻]項目に入力できるのは[最大長さは30の値]のみです。#n#';SF.setCheckSuccess(false); }
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
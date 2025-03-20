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
	 if(!checkIntegerType(getObj("recordtype"),"レコードタイプ",true,false)) { alertMsg += '[レコードタイプ]項目に入力できるのは[数字+[-]]のみです。#n#'; return false; }
	 if(getObj("emailreceiver")) {
	 if(!isLenMaxCheck(getObj("emailreceiver"),255,"受信者",true,false)) { alertMsg += '[受信者]項目に入力できるのは[最大長さは255の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("emailreceiver"),255,"受信者",true,true)) { alertMsg += '[受信者]項目に入力できるのは[最大長さは255の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(getObj("emailtitle")) {
	 if(!isLenMaxCheck(getObj("emailtitle"),1000,"メールタイトル",true,false)) { alertMsg += '[メールタイトル]項目に入力できるのは[最大長さは1000の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("emailtitle"),1000,"メールタイトル",true,true)) { alertMsg += '[メールタイトル]項目に入力できるのは[最大長さは1000の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(getObj("emailsender")) {
	 if(!isLenMaxCheck(getObj("emailsender"),255,"送信者",true,false)) { alertMsg += '[送信者]項目に入力できるのは[最大長さは255の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("emailsender"),255,"送信者",true,true)) { alertMsg += '[送信者]項目に入力できるのは[最大長さは255の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(!isDateTime(getObj("emailsendtime"),false,"送信時間",true,false)) { alertMsg += '[送信時間]項目に入力できるのは[日時]のみです。#n#'; return false; }
	 if(!checkIntegerType(getObj("matchid"),"マッチングID",true,false)) { alertMsg += '[マッチングID]項目に入力できるのは[数字+[-]]のみです。#n#'; return false; }
	 if(!checkIntegerType(getObj("txt26"),"コミュニケーションID",true,false)) { alertMsg += '[コミュニケーションID]項目に入力できるのは[数字+[-]]のみです。#n#'; return false; }
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
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
	 if(getObj("name")) {
	 if(!isLenMaxCheck(getObj("name"),50,"名前",true,false)) { alertMsg += '[名前]項目に入力できるのは[最大長さは50の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("name"),50,"名前",true,true)) { alertMsg += '[名前]項目に入力できるのは[最大長さは50の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(!checkIntegerType(getObj("sex"),"性别",true,false)) { alertMsg += '[性别]項目に入力できるのは[数字+[-]]のみです。#n#'; return false; }
	 if(getObj("age")) {
	 if(!isLenMaxCheck(getObj("age"),25,"年齢",true,false)) { alertMsg += '[年齢]項目に入力できるのは[最大長さは25の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("age"),25,"年齢",true,true)) { alertMsg += '[年齢]項目に入力できるのは[最大長さは25の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(getObj("address")) {
	 if(!isLenMaxCheck(getObj("address"),255,"住所",true,false)) { alertMsg += '[住所]項目に入力できるのは[最大長さは255の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("address"),255,"住所",true,true)) { alertMsg += '[住所]項目に入力できるのは[最大長さは255の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(getObj("price")) {
	 if(!isLenMaxCheck(getObj("price"),50,"単価",true,false)) { alertMsg += '[単価]項目に入力できるのは[最大長さは50の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("price"),50,"単価",true,true)) { alertMsg += '[単価]項目に入力できるのは[最大長さは50の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(getObj("companycurrent")) {
	 if(!isLenMaxCheck(getObj("companycurrent"),100,"現在の会社",true,false)) { alertMsg += '[現在の会社]項目に入力できるのは[最大長さは100の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("companycurrent"),100,"現在の会社",true,true)) { alertMsg += '[現在の会社]項目に入力できるのは[最大長さは100の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(getObj("certificate")) {
	 if(!isLenMaxCheck(getObj("certificate"),1000,"資格",true,false)) { alertMsg += '[資格]項目に入力できるのは[最大長さは1000の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("certificate"),1000,"資格",true,true)) { alertMsg += '[資格]項目に入力できるのは[最大長さは1000の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(getObj("introduction")) {
	 if(!isLenMaxCheck(getObj("introduction"),1000,"紹介",true,false)) { alertMsg += '[紹介]項目に入力できるのは[最大長さは1000の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("introduction"),1000,"紹介",true,true)) { alertMsg += '[紹介]項目に入力できるのは[最大長さは1000の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(getObj("entrytime")) {
	 if(!isLenMaxCheck(getObj("entrytime"),100,"入場可能時間",true,false)) { alertMsg += '[入場可能時間]項目に入力できるのは[最大長さは100の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("entrytime"),100,"入場可能時間",true,true)) { alertMsg += '[入場可能時間]項目に入力できるのは[最大長さは100の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(getObj("interviewtime")) {
	 if(!isLenMaxCheck(getObj("interviewtime"),100,"面接可能時間",true,false)) { alertMsg += '[面接可能時間]項目に入力できるのは[最大長さは100の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("interviewtime"),100,"面接可能時間",true,true)) { alertMsg += '[面接可能時間]項目に入力できるのは[最大長さは100の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(getObj("skills")) {
	 if(!isLenMaxCheck(getObj("skills"),255,"スキル",true,false)) { alertMsg += '[スキル]項目に入力できるのは[最大長さは255の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("skills"),255,"スキル",true,true)) { alertMsg += '[スキル]項目に入力できるのは[最大長さは255の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(getObj("remark")) {
	 if(!isLenMaxCheck(getObj("remark"),1000,"コメント",true,false)) { alertMsg += '[コメント]項目に入力できるのは[最大長さは1000の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("remark"),1000,"コメント",true,true)) { alertMsg += '[コメント]項目に入力できるのは[最大長さは1000の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(getObj("contact")) {
	 if(!isLenMaxCheck(getObj("contact"),50,"連絡先",true,false)) { alertMsg += '[連絡先]項目に入力できるのは[最大長さは50の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("contact"),50,"連絡先",true,true)) { alertMsg += '[連絡先]項目に入力できるのは[最大長さは50の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(getObj("contactmail")) {
	 if(!isLenMaxCheck(getObj("contactmail"),100,"連絡先メール",true,false)) { alertMsg += '[連絡先メール]項目に入力できるのは[最大長さは100の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("contactmail"),100,"連絡先メール",true,true)) { alertMsg += '[連絡先メール]項目に入力できるのは[最大長さは100の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(getObj("contactcompany")) {
	 if(!isLenMaxCheck(getObj("contactcompany"),255,"連絡先会社",true,false)) { alertMsg += '[連絡先会社]項目に入力できるのは[最大長さは255の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("contactcompany"),255,"連絡先会社",true,true)) { alertMsg += '[連絡先会社]項目に入力できるのは[最大長さは255の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(getObj("contactphone")) {
	 if(!isLenMaxCheck(getObj("contactphone"),100,"連絡先tel",true,false)) { alertMsg += '[連絡先tel]項目に入力できるのは[最大長さは100の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("contactphone"),100,"連絡先tel",true,true)) { alertMsg += '[連絡先tel]項目に入力できるのは[最大長さは100の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(getObj("contactaddress")) {
	 if(!isLenMaxCheck(getObj("contactaddress"),500,"連絡先アドレス",true,false)) { alertMsg += '[連絡先アドレス]項目に入力できるのは[最大長さは500の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("contactaddress"),500,"連絡先アドレス",true,true)) { alertMsg += '[連絡先アドレス]項目に入力できるのは[最大長さは500の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(getObj("emailsender")) {
	 if(!isLenMaxCheck(getObj("emailsender"),255,"送信者",true,false)) { alertMsg += '[送信者]項目に入力できるのは[最大長さは255の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("emailsender"),255,"送信者",true,true)) { alertMsg += '[送信者]項目に入力できるのは[最大長さは255の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(!isDateTime(getObj("emailsendtime"),false,"メール送信時刻",true,false)) { alertMsg += '[メール送信時刻]項目に入力できるのは[日時]のみです。#n#'; return false; }
	 if(getObj("emailtitle")) {
	 if(!isLenMaxCheck(getObj("emailtitle"),1000,"メールタイトル",true,false)) { alertMsg += '[メールタイトル]項目に入力できるのは[最大長さは1000の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("emailtitle"),1000,"メールタイトル",true,true)) { alertMsg += '[メールタイトル]項目に入力できるのは[最大長さは1000の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(getObj("emailattachment")) {
	 if(!isLenMaxCheck(getObj("emailattachment"),255,"メール添付パス",true,false)) { alertMsg += '[メール添付パス]項目に入力できるのは[最大長さは255の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("emailattachment"),255,"メール添付パス",true,true)) { alertMsg += '[メール添付パス]項目に入力できるのは[最大長さは255の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(getObj("txt56")) {
	 if(!isLenMaxCheck(getObj("txt56"),50,"国籍",true,false)) { alertMsg += '[国籍]項目に入力できるのは[最大長さは50の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("txt56"),50,"国籍",true,true)) { alertMsg += '[国籍]項目に入力できるのは[最大長さは50の値]のみです。#n#';SF.setCheckSuccess(false); }
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


/* define function end

/* dynamic define function end */

/* btn check end */

function DoMustCheck(){
    for (var i=1;i<=getObj('RowGrid21').value; i++) {
	}
if( !checkRequired(document.getElementById('shainid'),'社員ID',true,'項目「@@」が空白になっています。', true)) {SF.setCheckSuccess(false);}

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
    for (var i=1;i<=getObj('RowGrid21').value; i++) {
if (getObj("Grid21flg" + i) &&  (getObj("Grid21flg" + i).value != '')) {
 		if(!isLenCheck(getObj('USER_ID1_' + i), 10, "员工社員ID", true)) { alertMsg = '' + i +'行目の[员工社員ID]項目に入力できるのは[最大長さは10の値]のみです。'; alert(alertMsg); return false; } 		if(!isLenCheck(getObj('USER_NAME1_' + i), 30, "员工社員名", true)) { alertMsg = '' + i +'行目の[员工社員名]項目に入力できるのは[最大長さは30の値]のみです。'; alert(alertMsg); return false; } 		if(!isLenCheck(getObj('MAIL1_' + i), 100, "员工メールアドレス", true)) { alertMsg = '' + i +'行目の[员工メールアドレス]項目に入力できるのは[最大長さは100の値]のみです。'; alert(alertMsg); return false; } 		if(!isLenCheck(getObj('PHONE_NUMBER1_' + i), 30, "员工電話番号", true)) { alertMsg = '' + i +'行目の[员工電話番号]項目に入力できるのは[最大長さは30の値]のみです。'; alert(alertMsg); return false; } 		if(!isLenCheck(getObj('SEXUAL1_' + i), 2, "员工性別", true)) { alertMsg = '' + i +'行目の[员工性別]項目に入力できるのは[最大長さは2の値]のみです。'; alert(alertMsg); return false; }}	}
 if(getObj("shainid")) {
	 if(!isLenMaxCheck(getObj("shainid"),10,"社員ID",true)) { alertMsg = '[社員ID]項目に入力できるのは[最大長さは10の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("shainid"),10,"社員ID",true,true)) { alertMsg = '[社員ID]項目に入力できるのは[最大長さは10の値]のみです。';SF.setCheckSuccess(false); } if(getObj("shainmei")) {
	 if(!isLenMaxCheck(getObj("shainmei"),30,"社員名",true)) { alertMsg = '[社員名]項目に入力できるのは[最大長さは30の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("shainmei"),30,"社員名",true,true)) { alertMsg = '[社員名]項目に入力できるのは[最大長さは30の値]のみです。';SF.setCheckSuccess(false); } if(getObj("meeruadoresu")) {
	 if(!isLenMaxCheck(getObj("meeruadoresu"),100,"メールアドレス",true)) { alertMsg = '[メールアドレス]項目に入力できるのは[最大長さは100の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("meeruadoresu"),100,"メールアドレス",true,true)) { alertMsg = '[メールアドレス]項目に入力できるのは[最大長さは100の値]のみです。';SF.setCheckSuccess(false); } if(getObj("denwabangou")) {
	 if(!isLenMaxCheck(getObj("denwabangou"),30,"電話番号",true)) { alertMsg = '[電話番号]項目に入力できるのは[最大長さは30の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("denwabangou"),30,"電話番号",true,true)) { alertMsg = '[電話番号]項目に入力できるのは[最大長さは30の値]のみです。';SF.setCheckSuccess(false); } if(getObj("seibetsu")) {
	 if(!isLenMaxCheck(getObj("seibetsu"),2,"性別",true)) { alertMsg = '[性別]項目に入力できるのは[最大長さは2の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("seibetsu"),2,"性別",true,true)) { alertMsg = '[性別]項目に入力できるのは[最大長さは2の値]のみです。';SF.setCheckSuccess(false); }
    eval(SF.getItemCheckData());
    if (!SF.isCheckSuccess()) {
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

function F20091208153604208(){if (inputDataCheck()) {ajaxDoAdd();}}
function F20091210135248447(){doReturn();}
/* define function end

/* dynamic define function end */

/* btn check end */

function DoMustCheck(){
    if( !checkRequired(document.getElementById('kanriid'),'管理ID',true,'項目「@@」が空白になっています。', true)) {SF.setCheckSuccess(false);}

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
     if(getObj("kanriid")) {
	 if(!isLenMaxCheck(getObj("kanriid"),10,"管理ID",true)) { alertMsg = '[管理ID]項目に入力できるのは[最大長さは10の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("kanriid"),10,"管理ID",true,true)) { alertMsg = '[管理ID]項目に入力できるのは[最大長さは10の値]のみです。';SF.setCheckSuccess(false); } if(getObj("koushinkeiyakujouken")) {
	 if(!isLenMaxCheck(getObj("koushinkeiyakujouken"),100,"更新契約条件",true)) { alertMsg = '[更新契約条件]項目に入力できるのは[最大長さは100の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("koushinkeiyakujouken"),100,"更新契約条件",true,true)) { alertMsg = '[更新契約条件]項目に入力できるのは[最大長さは100の値]のみです。';SF.setCheckSuccess(false); } if(getObj("kaishamei")) {
	 if(!isLenMaxCheck(getObj("kaishamei"),100,"会社名",true)) { alertMsg = '[会社名]項目に入力できるのは[最大長さは100の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("kaishamei"),100,"会社名",true,true)) { alertMsg = '[会社名]項目に入力できるのは[最大長さは100の値]のみです。';SF.setCheckSuccess(false); } if(getObj("kaishameikana")) {
	 if(!isLenMaxCheck(getObj("kaishameikana"),100,"会社名カナ",true)) { alertMsg = '[会社名カナ]項目に入力できるのは[最大長さは100の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("kaishameikana"),100,"会社名カナ",true,true)) { alertMsg = '[会社名カナ]項目に入力できるのは[最大長さは100の値]のみです。';SF.setCheckSuccess(false); } if(getObj("daihyoushamei")) {
	 if(!isLenMaxCheck(getObj("daihyoushamei"),20,"代表者名",true)) { alertMsg = '[代表者名]項目に入力できるのは[最大長さは20の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("daihyoushamei"),20,"代表者名",true,true)) { alertMsg = '[代表者名]項目に入力できるのは[最大長さは20の値]のみです。';SF.setCheckSuccess(false); } if(getObj("daihyoushameikana")) {
	 if(!isLenMaxCheck(getObj("daihyoushameikana"),20,"代表者名カナ",true)) { alertMsg = '[代表者名カナ]項目に入力できるのは[最大長さは20の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("daihyoushameikana"),20,"代表者名カナ",true,true)) { alertMsg = '[代表者名カナ]項目に入力できるのは[最大長さは20の値]のみです。';SF.setCheckSuccess(false); } if(getObj("kaishashozaichi")) {
	 if(!isLenMaxCheck(getObj("kaishashozaichi"),100,"会社所在地",true)) { alertMsg = '[会社所在地]項目に入力できるのは[最大長さは100の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("kaishashozaichi"),100,"会社所在地",true,true)) { alertMsg = '[会社所在地]項目に入力できるのは[最大長さは100の値]のみです。';SF.setCheckSuccess(false); } if(getObj("kaishashozaichikana")) {
	 if(!isLenMaxCheck(getObj("kaishashozaichikana"),100,"会社所在地カナ",true)) { alertMsg = '[会社所在地カナ]項目に入力できるのは[最大長さは100の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("kaishashozaichikana"),100,"会社所在地カナ",true,true)) { alertMsg = '[会社所在地カナ]項目に入力できるのは[最大長さは100の値]のみです。';SF.setCheckSuccess(false); } if(getObj("kaishayuubinbangou")) {
	 if(!isLenMaxCheck(getObj("kaishayuubinbangou"),100,"会社郵便番号",true)) { alertMsg = '[会社郵便番号]項目に入力できるのは[最大長さは100の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("kaishayuubinbangou"),100,"会社郵便番号",true,true)) { alertMsg = '[会社郵便番号]項目に入力できるのは[最大長さは100の値]のみです。';SF.setCheckSuccess(false); } if(getObj("tantoushamei")) {
	 if(!isLenMaxCheck(getObj("tantoushamei"),100,"担当者名",true)) { alertMsg = '[担当者名]項目に入力できるのは[最大長さは100の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("tantoushamei"),100,"担当者名",true,true)) { alertMsg = '[担当者名]項目に入力できるのは[最大長さは100の値]のみです。';SF.setCheckSuccess(false); } if(getObj("tantoushameikana")) {
	 if(!isLenMaxCheck(getObj("tantoushameikana"),100,"担当者名カナ",true)) { alertMsg = '[担当者名カナ]項目に入力できるのは[最大長さは100の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("tantoushameikana"),100,"担当者名カナ",true,true)) { alertMsg = '[担当者名カナ]項目に入力できるのは[最大長さは100の値]のみです。';SF.setCheckSuccess(false); } if(getObj("juusho")) {
	 if(!isLenMaxCheck(getObj("juusho"),100,"住所",true)) { alertMsg = '[住所]項目に入力できるのは[最大長さは100の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("juusho"),100,"住所",true,true)) { alertMsg = '[住所]項目に入力できるのは[最大長さは100の値]のみです。';SF.setCheckSuccess(false); } if(getObj("juushokubun")) {
	 if(!isLenMaxCheck(getObj("juushokubun"),2,"住所区分",true)) { alertMsg = '[住所区分]項目に入力できるのは[最大長さは2の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("juushokubun"),2,"住所区分",true,true)) { alertMsg = '[住所区分]項目に入力できるのは[最大長さは2の値]のみです。';SF.setCheckSuccess(false); } if(getObj("juushokana")) {
	 if(!isLenMaxCheck(getObj("juushokana"),100,"住所カナ",true)) { alertMsg = '[住所カナ]項目に入力できるのは[最大長さは100の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("juushokana"),100,"住所カナ",true,true)) { alertMsg = '[住所カナ]項目に入力できるのは[最大長さは100の値]のみです。';SF.setCheckSuccess(false); } if(getObj("bushomei")) {
	 if(!isLenMaxCheck(getObj("bushomei"),100,"部署名",true)) { alertMsg = '[部署名]項目に入力できるのは[最大長さは100の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("bushomei"),100,"部署名",true,true)) { alertMsg = '[部署名]項目に入力できるのは[最大長さは100の値]のみです。';SF.setCheckSuccess(false); } if(getObj("bushomeikana")) {
	 if(!isLenMaxCheck(getObj("bushomeikana"),100,"部署名カナ",true)) { alertMsg = '[部署名カナ]項目に入力できるのは[最大長さは100の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("bushomeikana"),100,"部署名カナ",true,true)) { alertMsg = '[部署名カナ]項目に入力できるのは[最大長さは100の値]のみです。';SF.setCheckSuccess(false); } if(getObj("denwabangou")) {
	 if(!isLenMaxCheck(getObj("denwabangou"),100,"電話番号",true)) { alertMsg = '[電話番号]項目に入力できるのは[最大長さは100の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("denwabangou"),100,"電話番号",true,true)) { alertMsg = '[電話番号]項目に入力できるのは[最大長さは100の値]のみです。';SF.setCheckSuccess(false); } if(getObj("faxbangou")) {
	 if(!isLenMaxCheck(getObj("faxbangou"),100,"FAX番号",true)) { alertMsg = '[FAX番号]項目に入力できるのは[最大長さは100の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("faxbangou"),100,"FAX番号",true,true)) { alertMsg = '[FAX番号]項目に入力できるのは[最大長さは100の値]のみです。';SF.setCheckSuccess(false); } if(getObj("meeruadoresu")) {
	 if(!isLenMaxCheck(getObj("meeruadoresu"),100,"メールアドレス",true)) { alertMsg = '[メールアドレス]項目に入力できるのは[最大長さは100の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("meeruadoresu"),100,"メールアドレス",true,true)) { alertMsg = '[メールアドレス]項目に入力できるのは[最大長さは100の値]のみです。';SF.setCheckSuccess(false); } if(getObj("tantoushamei1")) {
	 if(!isLenMaxCheck(getObj("tantoushamei1"),100,"担当者名",true)) { alertMsg = '[担当者名]項目に入力できるのは[最大長さは100の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("tantoushamei1"),100,"担当者名",true,true)) { alertMsg = '[担当者名]項目に入力できるのは[最大長さは100の値]のみです。';SF.setCheckSuccess(false); } if(getObj("tantoushameikana1")) {
	 if(!isLenMaxCheck(getObj("tantoushameikana1"),100,"担当者名カナ",true)) { alertMsg = '[担当者名カナ]項目に入力できるのは[最大長さは100の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("tantoushameikana1"),100,"担当者名カナ",true,true)) { alertMsg = '[担当者名カナ]項目に入力できるのは[最大長さは100の値]のみです。';SF.setCheckSuccess(false); } if(getObj("juusho1")) {
	 if(!isLenMaxCheck(getObj("juusho1"),100,"住所",true)) { alertMsg = '[住所]項目に入力できるのは[最大長さは100の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("juusho1"),100,"住所",true,true)) { alertMsg = '[住所]項目に入力できるのは[最大長さは100の値]のみです。';SF.setCheckSuccess(false); } if(getObj("juushokubun1")) {
	 if(!isLenMaxCheck(getObj("juushokubun1"),2,"住所区分",true)) { alertMsg = '[住所区分]項目に入力できるのは[最大長さは2の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("juushokubun1"),2,"住所区分",true,true)) { alertMsg = '[住所区分]項目に入力できるのは[最大長さは2の値]のみです。';SF.setCheckSuccess(false); } if(getObj("juushokana1")) {
	 if(!isLenMaxCheck(getObj("juushokana1"),100,"住所カナ",true)) { alertMsg = '[住所カナ]項目に入力できるのは[最大長さは100の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("juushokana1"),100,"住所カナ",true,true)) { alertMsg = '[住所カナ]項目に入力できるのは[最大長さは100の値]のみです。';SF.setCheckSuccess(false); } if(getObj("bushomei1")) {
	 if(!isLenMaxCheck(getObj("bushomei1"),100,"部署名",true)) { alertMsg = '[部署名]項目に入力できるのは[最大長さは100の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("bushomei1"),100,"部署名",true,true)) { alertMsg = '[部署名]項目に入力できるのは[最大長さは100の値]のみです。';SF.setCheckSuccess(false); } if(getObj("bushomeikana1")) {
	 if(!isLenMaxCheck(getObj("bushomeikana1"),100,"部署名カナ",true)) { alertMsg = '[部署名カナ]項目に入力できるのは[最大長さは100の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("bushomeikana1"),100,"部署名カナ",true,true)) { alertMsg = '[部署名カナ]項目に入力できるのは[最大長さは100の値]のみです。';SF.setCheckSuccess(false); } if(getObj("denwabangou1")) {
	 if(!isLenMaxCheck(getObj("denwabangou1"),100,"電話番号",true)) { alertMsg = '[電話番号]項目に入力できるのは[最大長さは100の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("denwabangou1"),100,"電話番号",true,true)) { alertMsg = '[電話番号]項目に入力できるのは[最大長さは100の値]のみです。';SF.setCheckSuccess(false); } if(getObj("faxbangou1")) {
	 if(!isLenMaxCheck(getObj("faxbangou1"),100,"FAX番号",true)) { alertMsg = '[FAX番号]項目に入力できるのは[最大長さは100の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("faxbangou1"),100,"FAX番号",true,true)) { alertMsg = '[FAX番号]項目に入力できるのは[最大長さは100の値]のみです。';SF.setCheckSuccess(false); } if(getObj("meeruadoresu1")) {
	 if(!isLenMaxCheck(getObj("meeruadoresu1"),100,"メールアドレス",true)) { alertMsg = '[メールアドレス]項目に入力できるのは[最大長さは100の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("meeruadoresu1"),100,"メールアドレス",true,true)) { alertMsg = '[メールアドレス]項目に入力できるのは[最大長さは100の値]のみです。';SF.setCheckSuccess(false); }
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
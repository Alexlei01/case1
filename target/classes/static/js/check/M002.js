
function M002KAISHA1(){var KAISHA = getObj("KAISHA").value;
SF.setServerExecute(true);
/*1.画面項目「会社」を取得。*/
/*2.「役割」に<会社>を設定する。*/
SF.setComboboxValue('YAKUWARI',KAISHA);
$('#YAKUWARI').blur();
/*処理終了。*/
}
function F20091208153604208(){if (inputDataCheck()) {ajaxDoAdd();}}
function F20091210135248447(){doReturn();}
/* define function end

/* dynamic define function end */

/* btn check end */

function DoMustCheck(){
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
     if(getObj("shainid")) {
	 if(!isLenMaxCheck(getObj("shainid"),10,"社員ID",true)) { alertMsg = '[社員ID]項目に入力できるのは[最大長さは10の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("shainid"),10,"社員ID",true,true)) { alertMsg = '[社員ID]項目に入力できるのは[最大長さは10の値]のみです。';SF.setCheckSuccess(false); } if(getObj("shainmei")) {
	 if(!isLenMaxCheck(getObj("shainmei"),30,"社員名",true)) { alertMsg = '[社員名]項目に入力できるのは[最大長さは30の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("shainmei"),30,"社員名",true,true)) { alertMsg = '[社員名]項目に入力できるのは[最大長さは30の値]のみです。';SF.setCheckSuccess(false); } if(getObj("seibetsu")) {
	 if(!isLenMaxCheck(getObj("seibetsu"),2,"性別",true)) { alertMsg = '[性別]項目に入力できるのは[最大長さは2の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("seibetsu"),2,"性別",true,true)) { alertMsg = '[性別]項目に入力できるのは[最大長さは2の値]のみです。';SF.setCheckSuccess(false); } if(getObj("kaisha")) {
	 if(!isLenMaxCheck(getObj("kaisha"),10,"会社",true)) { alertMsg = '[会社]項目に入力できるのは[最大長さは10の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("kaisha"),10,"会社",true,true)) { alertMsg = '[会社]項目に入力できるのは[最大長さは10の値]のみです。';SF.setCheckSuccess(false); } if(getObj("meeruadoresu")) {
	 if(!isLenMaxCheck(getObj("meeruadoresu"),100,"メールアドレス",true)) { alertMsg = '[メールアドレス]項目に入力できるのは[最大長さは100の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("meeruadoresu"),100,"メールアドレス",true,true)) { alertMsg = '[メールアドレス]項目に入力できるのは[最大長さは100の値]のみです。';SF.setCheckSuccess(false); } if(getObj("denwabangou")) {
	 if(!isLenMaxCheck(getObj("denwabangou"),30,"電話番号",true)) { alertMsg = '[電話番号]項目に入力できるのは[最大長さは30の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("denwabangou"),30,"電話番号",true,true)) { alertMsg = '[電話番号]項目に入力できるのは[最大長さは30の値]のみです。';SF.setCheckSuccess(false); }
	 if(!isDate(getObj("tanjoubi"),false,"誕生日",true)) { alertMsg = '[誕生日]項目に入力できるのは[日付]のみです。'; return false; } if(getObj("yuukoufuragu")) {
	 if(!isLenMaxCheck(getObj("yuukoufuragu"),2,"有効フラグ",true)) { alertMsg = '[有効フラグ]項目に入力できるのは[最大長さは2の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("yuukoufuragu"),2,"有効フラグ",true,true)) { alertMsg = '[有効フラグ]項目に入力できるのは[最大長さは2の値]のみです。';SF.setCheckSuccess(false); } if(getObj("roguinid")) {
	 if(!isLenMaxCheck(getObj("roguinid"),30,"ログインID",true)) { alertMsg = '[ログインID]項目に入力できるのは[最大長さは30の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("roguinid"),30,"ログインID",true,true)) { alertMsg = '[ログインID]項目に入力できるのは[最大長さは30の値]のみです。';SF.setCheckSuccess(false); } if(getObj("pasuwaado")) {
	 if(!isLenMaxCheck(getObj("pasuwaado"),30,"パスワード",true)) { alertMsg = '[パスワード]項目に入力できるのは[最大長さは30の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("pasuwaado"),30,"パスワード",true,true)) { alertMsg = '[パスワード]項目に入力できるのは[最大長さは30の値]のみです。';SF.setCheckSuccess(false); } if(getObj("yakuwari")) {
	 if(!isLenMaxCheck(getObj("yakuwari"),10,"役割",true)) { alertMsg = '[役割]項目に入力できるのは[最大長さは10の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("yakuwari"),10,"役割",true,true)) { alertMsg = '[役割]項目に入力できるのは[最大長さは10の値]のみです。';SF.setCheckSuccess(false); }
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
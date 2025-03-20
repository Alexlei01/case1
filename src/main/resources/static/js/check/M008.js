
function F20091208153604208(){if (inputDataCheck()) {ajaxDoAdd();}}
function F20091210135248447(){doReturn();}
/* define function end

/* dynamic define function end */

/* btn check end */

function DoMustCheck(){
    return true;
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
     if(getObj("ankenmei")) {
	 if(!isLenMaxCheck(getObj("ankenmei"),50,"案件名",true)) { alertMsg = '[案件名]項目に入力できるのは[最大長さは50の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("ankenmei"),50,"案件名",true,true)) { alertMsg = '[案件名]項目に入力できるのは[最大長さは50の値]のみです。';SF.setCheckSuccess(false); } if(getObj("torihikisaki")) {
	 if(!isLenMaxCheck(getObj("torihikisaki"),10,"取引先",true)) { alertMsg = '[取引先]項目に入力できるのは[最大長さは10の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("torihikisaki"),10,"取引先",true,true)) { alertMsg = '[取引先]項目に入力できるのは[最大長さは10の値]のみです。';SF.setCheckSuccess(false); } if(getObj("yuukoufuragu")) {
	 if(!isLenMaxCheck(getObj("yuukoufuragu"),2,"有効フラグ",true)) { alertMsg = '[有効フラグ]項目に入力できるのは[最大長さは2の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("yuukoufuragu"),2,"有効フラグ",true,true)) { alertMsg = '[有効フラグ]項目に入力できるのは[最大長さは2の値]のみです。';SF.setCheckSuccess(false); }
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

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
     if(getObj("kubun")) {
	 if(!isLenMaxCheck(getObj("kubun"),2,"区分",true)) { alertMsg = '[区分]項目に入力できるのは[最大長さは2の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("kubun"),2,"区分",true,true)) { alertMsg = '[区分]項目に入力できるのは[最大長さは2の値]のみです。';SF.setCheckSuccess(false); } if(getObj("kenmei")) {
	 if(!isLenMaxCheck(getObj("kenmei"),50,"件名",true)) { alertMsg = '[件名]項目に入力できるのは[最大長さは50の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("kenmei"),50,"件名",true,true)) { alertMsg = '[件名]項目に入力できるのは[最大長さは50の値]のみです。';SF.setCheckSuccess(false); }
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
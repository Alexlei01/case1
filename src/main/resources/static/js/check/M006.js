
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
     if(getObj("saabisumei")) {
	 if(!isLenMaxCheck(getObj("saabisumei"),30,"サービス名",true)) { alertMsg = '[サービス名]項目に入力できるのは[最大長さは30の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("saabisumei"),30,"サービス名",true,true)) { alertMsg = '[サービス名]項目に入力できるのは[最大長さは30の値]のみです。';SF.setCheckSuccess(false); }
	 if(!checkIntegerType(getObj("hyoujijunjo"),"表示順序",true)) { alertMsg = '[表示順序]項目に入力できるのは[数字+[-]]のみです。'; return false; } if(getObj("yuukoufuragu")) {
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
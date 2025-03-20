
function F20091208153604208(){if (inputDataCheck()) {ajaxDoAdd();}}

/* define function end

/* dynamic define function end */
function smart13Check(){

 return true;
}

/* btn check end */

function DoMustCheck(){
    for (var i=1;i<=getObj('RowGrid17').value; i++) {
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
    for (var i=1;i<=getObj('RowGrid17').value; i++) {
if (getObj("Grid17flg" + i) &&  (getObj("Grid17flg" + i).value != '')) {
 		if(!isLenCheck(getObj('ORIGIN_TEXT_' + i), 50, "置換元文字", true)) { alertMsg = '' + i +'行目の[置換元文字]項目に入力できるのは[最大長さは50の値]のみです。'; alert(alertMsg); return false; } 		if(!isLenCheck(getObj('REPLACE_TEXT_' + i), 50, "置換文字", true)) { alertMsg = '' + i +'行目の[置換文字]項目に入力できるのは[最大長さは50の値]のみです。'; alert(alertMsg); return false; } 		if(!isLenCheck(getObj('EFF_STATUS_' + i), 1, "ステータス", true)) { alertMsg = '' + i +'行目の[ステータス]項目に入力できるのは[最大長さは1の値]のみです。'; alert(alertMsg); return false; }}	}

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
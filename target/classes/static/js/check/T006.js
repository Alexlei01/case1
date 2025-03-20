

/* define function end

/* dynamic define function end */

/* btn check end */

function DoMustCheck(){
    for (var i=1;i<=getObj('RowGrid13').value; i++) {
	if (getObj("Grid13flg" + i)) if (getObj("Grid13flg" + i).value != '0') {
		if( !checkRequired(getObj('COMPANY_NAME_' + i),"会社名",true,"第"+i+"行項目「@@」が空白になっています。")) return false;	}
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
    for (var i=1;i<=getObj('RowGrid13').value; i++) {
if (getObj("Grid13flg" + i) &&  (getObj("Grid13flg" + i).value != '')) {
 		if(!isLenCheck(getObj('COMPANY_NAME_' + i), 30, "会社名", true)) { alertMsg = '' + i +'行目の[会社名]項目に入力できるのは[最大長さは30の値]のみです。'; alert(alertMsg); return false; }}	}

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
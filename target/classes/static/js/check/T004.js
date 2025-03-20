

/* define function end

/* dynamic define function end */
function smart19Check(){

 return true;
}

/* btn check end */

function DoMustCheck(){
    for (var i=1;i<=getObj('RowGrid21').value; i++) {
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
    for (var i=1;i<=getObj('RowGrid21').value; i++) {
if (getObj("Grid21flg" + i) &&  (getObj("Grid21flg" + i).value != '')) {
}	}

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

function doLinkTrans17(){ SF.setServerExecute(true);

 pageLinkTranfer("T004T001i.do?","0","","","","_self","","0","1595","638");
}
function doLinkTrans37(o){ SF.setServerExecute(true);

 pageLinkTranfer("T004T001u.do?","1",o,"orderid,","orderid,","_self","","0","1595","638");
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
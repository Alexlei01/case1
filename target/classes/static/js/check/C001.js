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
	 if(!checkIntegerType(getObj("jobid"),"案件ID",true,false)) { alertMsg += '[案件ID]項目に入力できるのは[数字+[-]]のみです。#n#'; return false; }
	 if(!checkIntegerType(getObj("peopleid"),"技術者ID",true,false)) { alertMsg += '[技術者ID]項目に入力できるのは[数字+[-]]のみです。#n#'; return false; }
	 if(getObj("remark")) {
	 if(!isLenMaxCheck(getObj("remark"),255,"コメント",true,false)) { alertMsg += '[コメント]項目に入力できるのは[最大長さは255の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("remark"),255,"コメント",true,true)) { alertMsg += '[コメント]項目に入力できるのは[最大長さは255の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(getObj("status")) {
	 if(!checkIntegerType(getObj("status"),"ステータス",true,false)) { alertMsg += '[ステータス]項目に入力できるのは[数字+[-]]のみです。#n#'; return false; }
	 if(!isLenMaxCheck(getObj("status"),255,"ステータス",true,false)) { alertMsg += '[ステータス]項目に入力できるのは[最大長さは255の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("status"),255,"ステータス",true,true)) { alertMsg += '[ステータス]項目に入力できるのは[最大長さは255の値]のみです。#n#';SF.setCheckSuccess(false); }
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
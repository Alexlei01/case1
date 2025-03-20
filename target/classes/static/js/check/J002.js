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
	 if(getObj("jobname")) {
	 if(!isLenMaxCheck(getObj("jobname"),255,"案件名",true,false)) { alertMsg += '[案件名]項目に入力できるのは[最大長さは255の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("jobname"),255,"案件名",true,true)) { alertMsg += '[案件名]項目に入力できるのは[最大長さは255の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(!checkIntegerType(getObj("peopleid"),"技術者ID",true,false)) { alertMsg += '[技術者ID]項目に入力できるのは[数字+[-]]のみです。#n#'; return false; }
	 if(getObj("peoplename")) {
	 if(!isLenMaxCheck(getObj("peoplename"),255,"技術者名",true,false)) { alertMsg += '[技術者名]項目に入力できるのは[最大長さは255の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("peoplename"),255,"技術者名",true,true)) { alertMsg += '[技術者名]項目に入力できるのは[最大長さは255の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(!checkIntegerType(getObj("matchpercent"),"マッチング率",true,false)) { alertMsg += '[マッチング率]項目に入力できるのは[数字+[-]]のみです。#n#'; return false; }
	 if(getObj("matchcode")) {
	 if(!isLenMaxCheck(getObj("matchcode"),255,"マッチングコード",true,false)) { alertMsg += '[マッチングコード]項目に入力できるのは[最大長さは255の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("matchcode"),255,"マッチングコード",true,true)) { alertMsg += '[マッチングコード]項目に入力できるのは[最大長さは255の値]のみです。#n#';SF.setCheckSuccess(false); }
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

function doLinkTrans16(){ SF.setServerExecute(true);

	pageLinkTranfer("L00001.do?","0","","txt2,","txt2,","_blank","","0","","");
}
function doLinkTrans17(){ SF.setServerExecute(true);

	pageLinkTranfer("L00002.do?","0","","peopleId,","peopleId,","_blank","","0","","");
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
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
	 if(!checkIntegerType(getObj("tagtype"),"タグタイプ",true,false)) { alertMsg += '[タグタイプ]項目に入力できるのは[数字+[-]]のみです。#n#'; return false; }
	 if(!checkIntegerType(getObj("tagid"),"タグID",true,false)) { alertMsg += '[タグID]項目に入力できるのは[数字+[-]]のみです。#n#'; return false; }
	 if(!checkIntegerType(getObj("numberstart"),"開始番号",true,false)) { alertMsg += '[開始番号]項目に入力できるのは[数字+[-]]のみです。#n#'; return false; }
	 if(!checkIntegerType(getObj("numberend"),"終了番号",true,false)) { alertMsg += '[終了番号]項目に入力できるのは[数字+[-]]のみです。#n#'; return false; }
	 if(getObj("value")) {
	 if(!isLenMaxCheck(getObj("value"),255,"値",true,false)) { alertMsg += '[値]項目に入力できるのは[最大長さは255の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("value"),255,"値",true,true)) { alertMsg += '[値]項目に入力できるのは[最大長さは255の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(!checkIntegerType(getObj("detailid"),"詳細ID",true,false)) { alertMsg += '[詳細ID]項目に入力できるのは[数字+[-]]のみです。#n#'; return false; }
	 if(getObj("tagcode")) {
	 if(!isLenMaxCheck(getObj("tagcode"),25,"タグコード",true,false)) { alertMsg += '[タグコード]項目に入力できるのは[最大長さは25の値]のみです。#n#'; return false; }
	 }
	 if(!isLenCheck(getObj("tagcode"),25,"タグコード",true,true)) { alertMsg += '[タグコード]項目に入力できるのは[最大長さは25の値]のみです。#n#';SF.setCheckSuccess(false); }
	 if(!isDateTime(getObj("emailsendtime"),false,"メール送信時刻",true,false)) { alertMsg += '[メール送信時刻]項目に入力できるのは[日時]のみです。#n#'; return false; }
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
// VueCheckJS.vm

/* dynamic define function end */
function smart6Check(){

 return true;
}

/* btn check end */

function DoMustCheck(){
    for (let i=1; ;i++) {
	let elm = getObj("rowgrid1" + i)
	if(!elm || $(elm).attr("gridOpFlag") == 0) break
		if( !checkRequired(getObj('configcode' + i),"コード",true,"第"+ i +"行項目「@@」が空白になっています。")) return false;	}

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
    for (let i=1; ;i++) {
	let elm = getObj("rowgrid1" + i)
	if(!elm || $(elm).attr("gridOpFlag") == 0) break
 		if(!checkIntegerType(getObj('id' + i), "id", true, "項目「@@」には数値を入力して下さい。")) { alertMsg += '' + i +'行目の[id]項目に入力できるのは[数字+[-]]のみです。#n#'; } 		if(!isLenCheck(getObj('configcode' + i), 100, "コード", true)) { alertMsg += '' + i +'行目の[コード]項目に入力できるのは[最大長さは100の値]のみです。#n#'; } 		if(!isLenCheck(getObj('value' + i), 255, "値", true)) { alertMsg += '' + i +'行目の[値]項目に入力できるのは[最大長さは255の値]のみです。#n#'; } 		if(!isLenCheck(getObj('description' + i), 100, "説明", true)) { alertMsg += '' + i +'行目の[説明]項目に入力できるのは[最大長さは100の値]のみです。#n#'; }	}

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
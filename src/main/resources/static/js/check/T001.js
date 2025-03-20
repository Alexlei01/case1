// VueCheckJS.vm

/* dynamic define function end */

/* btn check end */

function DoMustCheck(){
    // for (var i=1;i<=getObj('rowgrid87').value; i++) {
	// if (getObj("Grid87flg" + i)) if (getObj("Grid87flg" + i).value != '0') {
	// 	if( !checkRequired(getObj('serviceid' + i),"サービス名",true,"第"+i+"行項目「@@」が空白になっています。")) return false;	}


	// if (getObj("Grid87flg" + i)) if (getObj("Grid87flg" + i).value != '0') {
	// 	if( !checkRequired(getObj('servicefunction' + i),"サービス機能",true,"第"+i+"行項目「@@」が空白になっています。")) return false;	}


	// if (getObj("Grid87flg" + i)) if (getObj("Grid87flg" + i).value != '0') {
	// 	if( !checkRequired(getObj('quantity' + i),"数量",true,"第"+i+"行項目「@@」が空白になっています。")) return false;	}
	// if (getObj("Grid87flg" + i)) if (getObj("Grid87flg" + i).value != '0') {
	// 	if( !checkRequired(getObj('unit' + i),"単位",true,"第"+i+"行項目「@@」が空白になっています。")) return false;	}
	// if (getObj("Grid87flg" + i)) if (getObj("Grid87flg" + i).value != '0') {
	// 	if( !checkRequired(getObj('wvpriceinitialcost' + i),"WV向け価格（初期費）",true,"第"+i+"行項目「@@」が空白になっています。")) return false;	}
	// if (getObj("Grid87flg" + i)) if (getObj("Grid87flg" + i).value != '0') {
	// 	if( !checkRequired(getObj('wvpricemonthly' + i),"WV向け価格（月額）",true,"第"+i+"行項目「@@」が空白になっています。")) return false;	}
	// }

    for (let i=1; ;i++) {
        let elm = getObj("rowgrid87" + i)
        if(!elm || $(elm).attr("gridOpFlag") == 0) break

        if(!checkRequired(getObj('serviceid'+i),"サービス名",true,"第"+i+"行項目「@@」が空白になっています。")) return false
        if(!checkRequired(getObj('servicefunction'+i),"サービス機能",true,"第"+i+"行項目「@@」が空白になっています。")) return false
    
        // 其他变量等同处理……
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
//     for (var i=1;i<=getObj('rowgrid87').value; i++) {
// if (getObj("grid87flg" + i) &&  (getObj("grid87flg" + i).value != '')) {
//  		if(!isLenCheck(getObj('serviceid' + i), 10, "サービス名", true)) { alertMsg = '' + i +'行目の[サービス名]項目に入力できるのは[最大長さは10の値]のみです。'; alert(alertMsg); return false; } 		if(!isLenCheck(getObj('servicefunction' + i), 100, "サービス機能", true)) { alertMsg = '' + i +'行目の[サービス機能]項目に入力できるのは[最大長さは100の値]のみです。'; alert(alertMsg); return false; } 		if(!checkIntegerType(getObj('quantity' + i), "数量", true, "項目「@@」には数値を入力して下さい。")) { alertMsg = '' + i +'行目の[数量]項目に入力できるのは[数字+[-]]のみです。'; alert(alertMsg); return false; } 		if(!isLenCheck(getObj('unit' + i), 10, "単位", true)) { alertMsg = '' + i +'行目の[単位]項目に入力できるのは[最大長さは10の値]のみです。'; alert(alertMsg); return false; } 		if(!checkIntegerType(getObj('wvpriceinitialcost' + i), "WV向け価格（初期費）", true, "項目「@@」には数値を入力して下さい。")) { alertMsg = '' + i +'行目の[WV向け価格（初期費）]項目に入力できるのは[数字+[-]]のみです。'; alert(alertMsg); return false; } 		if(!checkIntegerType(getObj('wvpricemonthly' + i), "WV向け価格（月額）", true, "項目「@@」には数値を入力して下さい。")) { alertMsg = '' + i +'行目の[WV向け価格（月額）]項目に入力できるのは[数字+[-]]のみです。'; alert(alertMsg); return false; } 		if(!isLenCheck(getObj('orderid1' + i), 15, "申込ID1", true)) { alertMsg = '' + i +'行目の[申込ID1]項目に入力できるのは[最大長さは15の値]のみです。'; alert(alertMsg); return false; } 		if(!isLenCheck(getObj('productid' + i), 15, "商品ID", true)) { alertMsg = '' + i +'行目の[商品ID]項目に入力できるのは[最大長さは15の値]のみです。'; alert(alertMsg); return false; }}	}

    for (let i=1; ;i++) {
        let elm = getObj("rowgrid87" + i)
        if(!elm || $(elm).attr("gridOpFlag") == 0) break

        if(!isLenCheck(getObj('serviceid'+i), 10, "サービス名", true)) {
            alertMsg = '' + i +'行目の[サービス名]項目に入力できるのは[最大長さは10の値]のみです。';
            alert(alertMsg);
            return false;
        }
        if(!isLenCheck(getObj('servicefunction'+i), 100, "サービス機能", true)) {
            alertMsg = '' + i +'行目の[サービス機能]項目に入力できるのは[最大長さは100の値]のみです。';
            alert(alertMsg);
            return false;
        } 

        // 其他变量等同处理……
    }

    if(!isDate(getObj("moushikomibi"),false,"申込日",true)) { alertMsg = '[申込日]項目に入力できるのは[日付]のみです。'; return false; }
    if(!isDate(getObj("riyoukaishikiboubi"),false,"利用開始希望日",true)) { alertMsg = '[利用開始希望日]項目に入力できるのは[日付]のみです。'; return false; }
    if(!isDate(getObj("ukeirebi"),false,"受入日",true)) { alertMsg = '[受入日]項目に入力できるのは[日付]のみです。'; return false; }
    if(!isDate(getObj("kaiyakubi"),false,"解約日",true)) { alertMsg = '[解約日]項目に入力できるのは[日付]のみです。'; return false; } if(getObj("torihikisaki")) {
    if(!isLenMaxCheck(getObj("torihikisaki"),10,"取引先",true)) { alertMsg = '[取引先]項目に入力できるのは[最大長さは10の値]のみです。'; return false; }
    }
    if(!isLenCheck(getObj("torihikisaki"),10,"取引先",true,true)) { alertMsg = '[取引先]項目に入力できるのは[最大長さは10の値]のみです。';SF.setCheckSuccess(false); } if(getObj("ankenmei")) {
    if(!isLenMaxCheck(getObj("ankenmei"),10,"案件名",true)) { alertMsg = '[案件名]項目に入力できるのは[最大長さは10の値]のみです。'; return false; }
    }
    if(!isLenCheck(getObj("ankenmei"),10,"案件名",true,true)) { alertMsg = '[案件名]項目に入力できるのは[最大長さは10の値]のみです。';SF.setCheckSuccess(false); }
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
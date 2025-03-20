
function F20091208153604208(){if (inputDataCheck()) {ajaxDoAdd();}}
function F20091210135248447(){doReturn();}
/* define function end

/* dynamic define function end */

/* btn check end */

function DoMustCheck(){
    if( !checkRequired(document.getElementById('shouhinkataban'),'商品型番',true,'項目「@@」が空白になっています。', true)) {SF.setCheckSuccess(false);}
if( !checkRequired(document.getElementById('sfasaabisumei'),'SFAサービス名',true,'項目「@@」が空白になっています。', true)) {SF.setCheckSuccess(false);}
if( !checkRequired(document.getElementById('seikyuutsukikubun'),'請求月区分',true,'項目「@@」が空白になっています。', true)) {SF.setCheckSuccess(false);}

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
     if(getObj("shouhinkataban")) {
	 if(!isLenMaxCheck(getObj("shouhinkataban"),50,"商品型番",true)) { alertMsg = '[商品型番]項目に入力できるのは[最大長さは50の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("shouhinkataban"),50,"商品型番",true,true)) { alertMsg = '[商品型番]項目に入力できるのは[最大長さは50の値]のみです。';SF.setCheckSuccess(false); } if(getObj("saabisumei")) {
	 if(!isLenMaxCheck(getObj("saabisumei"),10,"サービス名",true)) { alertMsg = '[サービス名]項目に入力できるのは[最大長さは10の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("saabisumei"),10,"サービス名",true,true)) { alertMsg = '[サービス名]項目に入力できるのは[最大長さは10の値]のみです。';SF.setCheckSuccess(false); } if(getObj("saabisukinou")) {
	 if(!isLenMaxCheck(getObj("saabisukinou"),100,"サービス機能",true)) { alertMsg = '[サービス機能]項目に入力できるのは[最大長さは100の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("saabisukinou"),100,"サービス機能",true,true)) { alertMsg = '[サービス機能]項目に入力できるのは[最大長さは100の値]のみです。';SF.setCheckSuccess(false); } if(getObj("sfasaabisumei")) {
	 if(!isLenMaxCheck(getObj("sfasaabisumei"),100,"SFAサービス名",true)) { alertMsg = '[SFAサービス名]項目に入力できるのは[最大長さは100の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("sfasaabisumei"),100,"SFAサービス名",true,true)) { alertMsg = '[SFAサービス名]項目に入力できるのは[最大長さは100の値]のみです。';SF.setCheckSuccess(false); } if(getObj("tani")) {
	 if(!isLenMaxCheck(getObj("tani"),20,"単位",true)) { alertMsg = '[単位]項目に入力できるのは[最大長さは20の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("tani"),20,"単位",true,true)) { alertMsg = '[単位]項目に入力できるのは[最大長さは20の値]のみです。';SF.setCheckSuccess(false); } if(getObj("seikyuutsukikubun")) {
	 if(!isLenMaxCheck(getObj("seikyuutsukikubun"),1,"請求月区分",true)) { alertMsg = '[請求月区分]項目に入力できるのは[最大長さは1の値]のみです。'; return false; }
	 }
	 if(!isLenCheck(getObj("seikyuutsukikubun"),1,"請求月区分",true,true)) { alertMsg = '[請求月区分]項目に入力できるのは[最大長さは1の値]のみです。';SF.setCheckSuccess(false); }
	 if(!checkIntegerType(getObj("teikyoukakakushokihi"),"提供価格（初期費）",true)) { alertMsg = '[提供価格（初期費）]項目に入力できるのは[数字+[-]]のみです。'; return false; }
	 if(!checkIntegerType(getObj("teikyoukakakugetsugaku"),"提供価格（月額）",true)) { alertMsg = '[提供価格（月額）]項目に入力できるのは[数字+[-]]のみです。'; return false; }
	 if(!checkIntegerType(getObj("wvmukekakakushokihi"),"WV向け価格（初期費）",true)) { alertMsg = '[WV向け価格（初期費）]項目に入力できるのは[数字+[-]]のみです。'; return false; }
	 if(!checkIntegerType(getObj("wvmukekakakugetsugaku"),"WV向け価格（月額）",true)) { alertMsg = '[WV向け価格（月額）]項目に入力できるのは[数字+[-]]のみです。'; return false; }
	 if(!isDate(getObj("yuukoukikankaishi"),false,"有効期間（開始）",true)) { alertMsg = '[有効期間（開始）]項目に入力できるのは[日付]のみです。'; return false; }
	 if(!isDate(getObj("yuukoukikanshuuryou"),false,"有効期間（終了）",true)) { alertMsg = '[有効期間（終了）]項目に入力できるのは[日付]のみです。'; return false; } if(getObj("yuukoufuragu")) {
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

function T002KEIYAKUKAISHIBI1(){var SHUURYOUBI = "";
var KEIYAKUKAISHIBI = getObj("KEIYAKUKAISHIBI").value;
var dayslater365 = moment(KEIYAKUKAISHIBI).add(365, 'd').format('YYYY/MM/DD');
SF.setServerExecute(true);
/*1.変数<終了日>に「契約開始日」の365日後を設定する。*/
SHUURYOUBI = dayslater365;

/*2.変数<終了日>の日付表示形式を「yyyy/mm/dd」にする。*/
SHUURYOUBI = moment(SHUURYOUBI).format("YYYY/MM/DD");

/*3.「契約終了日」に<終了日>を設定する。*/
$('#KEIYAKUSHUURYOUBI').val(SHUURYOUBI == null || SHUURYOUBI == 'null'  ? '' : SHUURYOUBI);
$('#KEIYAKUSHUURYOUBI').blur();
/*処理終了。*/
}
function T002N181(){var pagemode = getObj("mode").value;
SF.setServerExecute(true);
/*1.画面初期化が新規の場合,以下の処理を行う。*/
if (pagemode == '2') {
	/*1.「先に保存してください」メッセージを表示する。*/
	alert('先に保存してください');
	/*処理終了。*/
}
/*2.その他の場合,以下の処理を行う。*/ else {
	/*1.「発注情報」ボタンを実行する処理終了。*/
	SF.setServerExecute(true);
	$('#AC18').click();

	/*処理終了。*/
}
}
function T002PageAfterLoad1(){var SUTEETASU = getObj("SUTEETASU").value;
SF.setServerExecute(true);
/*1.「ステータス」を取得。*/
/*2.<ステータス>が'1'の場合,以下の処理を行う。*/
if (SUTEETASU == '1') {
	/*1.「納期確定」を入力不可にする。*/
	SF.setDisabled('R18',true);
	/*2.「受付」を入力不可にする。*/
	SF.setDisabled('V18',true);
	/*処理終了。*/
}
/*3.<ステータス>が'2'の場合,以下の処理を行う。*/
if (SUTEETASU == '2') {
	/*1.「納期確定」を入力不可にする。*/
	SF.setDisabled('R18',true);
	/*処理終了。*/
}
/*4.<ステータス>が'3'の場合,以下の処理を行う。*/
if (SUTEETASU == '3') {
	/*1.「受付」を入力不可にする。*/
	SF.setDisabled('V18',true);
	/*処理終了。*/
}
/*4.<ステータス>が'4'の場合,以下の処理を行う。*/
if (SUTEETASU == '4') {
	/*1.「受付」を入力不可にする。*/
	SF.setDisabled('V18',true);
	/*2.「納期確定」を入力不可にする。*/
	SF.setDisabled('R18',true);
	/*3.「保存」を入力不可にする。*/
	SF.setDisabled('AC20',true);
	/*4.「利用開始希望日」を入力不可にする。*/
	SF.setDisabled('RIYOUKAISHIKIBOUBI',true);
	/*5.「契約開始日」を入力不可にする。*/
	SF.setDisabled('KEIYAKUKAISHIBI',true);
	/*6.「契約終了日」を入力不可にする。*/
	SF.setDisabled('KEIYAKUSHUURYOUBI',true);
	/*7.「予定納期」を入力不可にする。*/
	SF.setDisabled('YOTEINOUKI',true);
	/*7.「確定納期」を入力不可にする。*/
	SF.setDisabled('KAKUTEINOUKI',true);
	/*8.「メーカー備考」を入力不可にする。*/
	SF.setDisabled('MEEKAABIKOU',true);
	/*処理終了。*/
}
/*5.<ステータス>が'5'の場合,以下の処理を行う。*/
if (SUTEETASU == '5') {
	/*1.「受付」を入力不可にする。*/
	SF.setDisabled('V18',true);
	/*2.「納期確定」を入力不可にする。*/
	SF.setDisabled('R18',true);
	/*3.「保存」を入力不可にする。*/
	SF.setDisabled('AC20',true);
	/*4.「利用開始希望日」を入力不可にする。*/
	SF.setDisabled('RIYOUKAISHIKIBOUBI',true);
	/*5.「契約開始日」を入力不可にする。*/
	SF.setDisabled('KEIYAKUKAISHIBI',true);
	/*6.「契約終了日」を入力不可にする。*/
	SF.setDisabled('KEIYAKUSHUURYOUBI',true);
	/*7.「予定納期」を入力不可にする。*/
	SF.setDisabled('YOTEINOUKI',true);
	/*7.「確定納期」を入力不可にする。*/
	SF.setDisabled('KAKUTEINOUKI',true);
	/*8.「メーカー備考」を入力不可にする。*/
	SF.setDisabled('MEEKAABIKOU',true);
	/*処理終了。*/
}
/*6.<ステータス>が'6'の場合,以下の処理を行う。*/
if (SUTEETASU == '6') {
	/*1.「受付」を入力不可にする。*/
	SF.setDisabled('V18',true);
	/*2.「納期確定」を入力不可にする。*/
	SF.setDisabled('R18',true);
	/*3.「保存」を入力不可にする。*/
	SF.setDisabled('AC20',true);
	/*4.「利用開始希望日」を入力不可にする。*/
	SF.setDisabled('RIYOUKAISHIKIBOUBI',true);
	/*5.「契約開始日」を入力不可にする。*/
	SF.setDisabled('KEIYAKUKAISHIBI',true);
	/*6.「契約終了日」を入力不可にする。*/
	SF.setDisabled('KEIYAKUSHUURYOUBI',true);
	/*7.「予定納期」を入力不可にする。*/
	SF.setDisabled('YOTEINOUKI',true);
	/*7.「確定納期」を入力不可にする。*/
	SF.setDisabled('KAKUTEINOUKI',true);
	/*8.「メーカー備考」を入力不可にする。*/
	SF.setDisabled('MEEKAABIKOU',true);
	/*処理終了。*/
}
/*処理終了。*/
}
function T002R181(){var KAKUTEINOUKI = $('#KAKUTEINOUKI').val();
SF.setServerExecute(true);
/*1.「確定納期」が空白の場合,以下の処理を行う。*/
if ((KAKUTEINOUKI == null || KAKUTEINOUKI == "" ) ) {
	/*1.「確定納期」に当日を設定する。*/
	$('#KAKUTEINOUKI').val(moment().format('YYYY/MM/DD'));
	$('#KAKUTEINOUKI').blur();
	/*処理終了。*/
}
/*2.「ステータス」に'4'を設定する。*/
SF.setComboboxValue('SUTEETASU','4');
$('#SUTEETASU').blur();
/*3.「保存」ボタンを実行する。*/
SF.setServerExecute(true);
$('#AC20').click();

/*処理終了。*/
}
function T002V181(){SF.setServerExecute(true);
/*1.「ステータス」に'3'を設定する。*/
SF.setComboboxValue('SUTEETASU','3');
$('#SUTEETASU').blur();
/*2.「保存」ボタンを実行する。*/
SF.setServerExecute(true);
$('#AC20').click();

/*処理終了。*/
}
function F20091210135248447(){doReturn();}function F20091208153604208(){if (inputDataCheck()) {ajaxDoAdd();}}
function T002PageAfterLoad1(){var SUTEETASU = getObj("SUTEETASU").value;
SF.setServerExecute(true);
/*1.「ステータス」を取得。*/
/*2.<ステータス>が'1'の場合,以下の処理を行う。*/
if (SUTEETASU == '1') {
	/*1.「納期確定」を入力不可にする。*/
	SF.setDisabled('R18',true);
	/*2.「受付」を入力不可にする。*/
	SF.setDisabled('V18',true);
	/*処理終了。*/
}
/*3.<ステータス>が'2'の場合,以下の処理を行う。*/
if (SUTEETASU == '2') {
	/*1.「納期確定」を入力不可にする。*/
	SF.setDisabled('R18',true);
	/*処理終了。*/
}
/*4.<ステータス>が'3'の場合,以下の処理を行う。*/
if (SUTEETASU == '3') {
	/*1.「受付」を入力不可にする。*/
	SF.setDisabled('V18',true);
	/*処理終了。*/
}
/*4.<ステータス>が'4'の場合,以下の処理を行う。*/
if (SUTEETASU == '4') {
	/*1.「受付」を入力不可にする。*/
	SF.setDisabled('V18',true);
	/*2.「納期確定」を入力不可にする。*/
	SF.setDisabled('R18',true);
	/*3.「保存」を入力不可にする。*/
	SF.setDisabled('AC20',true);
	/*4.「利用開始希望日」を入力不可にする。*/
	SF.setDisabled('RIYOUKAISHIKIBOUBI',true);
	/*5.「契約開始日」を入力不可にする。*/
	SF.setDisabled('KEIYAKUKAISHIBI',true);
	/*6.「契約終了日」を入力不可にする。*/
	SF.setDisabled('KEIYAKUSHUURYOUBI',true);
	/*7.「予定納期」を入力不可にする。*/
	SF.setDisabled('YOTEINOUKI',true);
	/*7.「確定納期」を入力不可にする。*/
	SF.setDisabled('KAKUTEINOUKI',true);
	/*8.「メーカー備考」を入力不可にする。*/
	SF.setDisabled('MEEKAABIKOU',true);
	/*処理終了。*/
}
/*5.<ステータス>が'5'の場合,以下の処理を行う。*/
if (SUTEETASU == '5') {
	/*1.「受付」を入力不可にする。*/
	SF.setDisabled('V18',true);
	/*2.「納期確定」を入力不可にする。*/
	SF.setDisabled('R18',true);
	/*3.「保存」を入力不可にする。*/
	SF.setDisabled('AC20',true);
	/*4.「利用開始希望日」を入力不可にする。*/
	SF.setDisabled('RIYOUKAISHIKIBOUBI',true);
	/*5.「契約開始日」を入力不可にする。*/
	SF.setDisabled('KEIYAKUKAISHIBI',true);
	/*6.「契約終了日」を入力不可にする。*/
	SF.setDisabled('KEIYAKUSHUURYOUBI',true);
	/*7.「予定納期」を入力不可にする。*/
	SF.setDisabled('YOTEINOUKI',true);
	/*7.「確定納期」を入力不可にする。*/
	SF.setDisabled('KAKUTEINOUKI',true);
	/*8.「メーカー備考」を入力不可にする。*/
	SF.setDisabled('MEEKAABIKOU',true);
	/*処理終了。*/
}
/*6.<ステータス>が'6'の場合,以下の処理を行う。*/
if (SUTEETASU == '6') {
	/*1.「受付」を入力不可にする。*/
	SF.setDisabled('V18',true);
	/*2.「納期確定」を入力不可にする。*/
	SF.setDisabled('R18',true);
	/*3.「保存」を入力不可にする。*/
	SF.setDisabled('AC20',true);
	/*4.「利用開始希望日」を入力不可にする。*/
	SF.setDisabled('RIYOUKAISHIKIBOUBI',true);
	/*5.「契約開始日」を入力不可にする。*/
	SF.setDisabled('KEIYAKUKAISHIBI',true);
	/*6.「契約終了日」を入力不可にする。*/
	SF.setDisabled('KEIYAKUSHUURYOUBI',true);
	/*7.「予定納期」を入力不可にする。*/
	SF.setDisabled('YOTEINOUKI',true);
	/*7.「確定納期」を入力不可にする。*/
	SF.setDisabled('KAKUTEINOUKI',true);
	/*8.「メーカー備考」を入力不可にする。*/
	SF.setDisabled('MEEKAABIKOU',true);
	/*処理終了。*/
}
/*処理終了。*/
}

/* define function end

/* dynamic define function end */

/* btn check end */

function DoMustCheck(){
    for (var i=1;i<=getObj('RowGrid73').value; i++) {
	if (getObj("Grid73flg" + i)) if (getObj("Grid73flg" + i).value != '0') {
		if( !checkRequired(getObj('SERVICE_FUNCTION_' + i),"サービス機能",true,"第"+i+"行項目「@@」が空白になっています。")) return false;	}
	if (getObj("Grid73flg" + i)) if (getObj("Grid73flg" + i).value != '0') {
		if( !checkRequired(getObj('QUANTITY_' + i),"数量",true,"第"+i+"行項目「@@」が空白になっています。")) return false;	}
	if (getObj("Grid73flg" + i)) if (getObj("Grid73flg" + i).value != '0') {
		if( !checkRequired(getObj('UNIT_' + i),"単位",true,"第"+i+"行項目「@@」が空白になっています。")) return false;	}
	if (getObj("Grid73flg" + i)) if (getObj("Grid73flg" + i).value != '0') {
		if( !checkRequired(getObj('WV_PRICE_INITIAL_COST_' + i),"WV向け価格（初期費）",true,"第"+i+"行項目「@@」が空白になっています。")) return false;	}
	if (getObj("Grid73flg" + i)) if (getObj("Grid73flg" + i).value != '0') {
		if( !checkRequired(getObj('WV_PRICE_MONTHLY_' + i),"WV向け価格（月額）",true,"第"+i+"行項目「@@」が空白になっています。")) return false;	}
	if (getObj("Grid73flg" + i)) if (getObj("Grid73flg" + i).value != '0') {
		if( !checkRequired(getObj('AMOUNT_INITIAL_COST_' + i),"金額（初期費）",true,"第"+i+"行項目「@@」が空白になっています。")) return false;	}
	if (getObj("Grid73flg" + i)) if (getObj("Grid73flg" + i).value != '0') {
		if( !checkRequired(getObj('AMOUNT_MONTHLY_' + i),"金額（月額）",true,"第"+i+"行項目「@@」が空白になっています。")) return false;	}
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
    for (var i=1;i<=getObj('RowGrid73').value; i++) {
if (getObj("Grid73flg" + i) &&  (getObj("Grid73flg" + i).value != '')) {
 		if(!isLenCheck(getObj('SERVICE_FUNCTION_' + i), 100, "サービス機能", true)) { alertMsg = '' + i +'行目の[サービス機能]項目に入力できるのは[最大長さは100の値]のみです。'; alert(alertMsg); return false; } 		if(!checkIntegerType(getObj('QUANTITY_' + i), "数量", true, "項目「@@」には数値を入力して下さい。")) { alertMsg = '' + i +'行目の[数量]項目に入力できるのは[数字+[-]]のみです。'; alert(alertMsg); return false; } 		if(!isLenCheck(getObj('UNIT_' + i), 10, "単位", true)) { alertMsg = '' + i +'行目の[単位]項目に入力できるのは[最大長さは10の値]のみです。'; alert(alertMsg); return false; } 		if(!checkIntegerType(getObj('WV_PRICE_INITIAL_COST_' + i), "WV向け価格（初期費）", true, "項目「@@」には数値を入力して下さい。")) { alertMsg = '' + i +'行目の[WV向け価格（初期費）]項目に入力できるのは[数字+[-]]のみです。'; alert(alertMsg); return false; } 		if(!checkIntegerType(getObj('WV_PRICE_MONTHLY_' + i), "WV向け価格（月額）", true, "項目「@@」には数値を入力して下さい。")) { alertMsg = '' + i +'行目の[WV向け価格（月額）]項目に入力できるのは[数字+[-]]のみです。'; alert(alertMsg); return false; } 		if(!checkIntegerType(getObj('AMOUNT_INITIAL_COST_' + i), "金額（初期費）", true, "項目「@@」には数値を入力して下さい。")) { alertMsg = '' + i +'行目の[金額（初期費）]項目に入力できるのは[数字+[-]]のみです。'; alert(alertMsg); return false; } 		if(!checkIntegerType(getObj('AMOUNT_MONTHLY_' + i), "金額（月額）", true, "項目「@@」には数値を入力して下さい。")) { alertMsg = '' + i +'行目の[金額（月額）]項目に入力できるのは[数字+[-]]のみです。'; alert(alertMsg); return false; } 		if(!isLenCheck(getObj('ORDER_ID1_' + i), 15, "申込ID1", true)) { alertMsg = '' + i +'行目の[申込ID1]項目に入力できるのは[最大長さは15の値]のみです。'; alert(alertMsg); return false; }}	}

	 if(!isDate(getObj("keiyakukaishibi"),false,"契約開始日",true)) { alertMsg = '[契約開始日]項目に入力できるのは[日付]のみです。'; return false; }
	 if(!isDate(getObj("keiyakushuuryoubi"),false,"契約終了日",true)) { alertMsg = '[契約終了日]項目に入力できるのは[日付]のみです。'; return false; }
	 if(!isDate(getObj("yoteinouki"),false,"予定納期",true)) { alertMsg = '[予定納期]項目に入力できるのは[日付]のみです。'; return false; }
	 if(!isDate(getObj("kakuteinouki"),false,"確定納期",true)) { alertMsg = '[確定納期]項目に入力できるのは[日付]のみです。'; return false; }
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
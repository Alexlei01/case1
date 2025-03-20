let lang = null
let pageId = null
let mainId = null
let relData = null
let pageEvents = []
let tableEvents = []
let tableData = {}
let displayFrameFlg = null
let searchBtnItemId = null
let searchNextFun = null

let enterToTab = false

let pageWidth = 0

let ajaxNum = 0
function ajax(url, data, nextFun, processData) {
  let contentType = false
  if (processData !== false) {
    processData = true
    contentType = "application/json"
    data = JSON.stringify(data ? data : {})
  }
  $.ajax({
    url, type: "post", data, contentType, processData,
    beforeSend: () => {
      if (++ajaxNum == 1) $(".content-backdrop").fadeIn()
    },
    complete: () => {
      if (--ajaxNum == 0) $(".content-backdrop").fadeOut()
    },
    error: res => {
      // console.log(res)
    }, 
    success: res => {
      let data = res // nextFun
      if (typeof res == "string") {
        data = JSON.parse(res)
        if (data.e) {
          alert(data.e.trim())
          if (data.eu) eval(data.eu)
          return
        } else {
          if (data.r) eval(data.r)
          if (data.i) alert(data.i)
          if (data.u) window.open(data.u, "_blank")
          if (data.dataMainId) storageData(data)
        }
      }
      if (nextFun) eval(nextFun)
    }
  })
}
function saveAfter(data) {
  setFormData(data)

  let kvs = []
  $("[isprikey='true']").each(function() {
    $(this).attr("readonly", true)
    kvs.push({"key": $(this).attr("id"), value: $(this).val()})
  })
  let param = "kvs=" + JSON.stringify(kvs) + "&mode=1&actflg=2"
  
  let url = mainId
  url += getUrlSuffix()
  url += "?d=" + window.btoa(encodeURIComponent(param))
  history.replaceState(null, '', url)
}
function searchAfter(data) {
  setFormData(data)
  if (searchNextFun) eval(searchNextFun)
  $(".tableNav a").each(function() {
    if ($(this).text() == 1) $(this).click()
  })
}
function searchPageAfter(data) {
  data.dataMainId = mainId
  storageData(data)
  setFormData(data)
  $(".tableNav a").each(function() {
    if ($(this).text() == 1) $(this).click()
  })
}
function storageData(data) {
  let list = data[`storage.${data.dataMainId}SearchResult`] || filterPageSearchData(data)
  sessionStorage[data.dataMainId] = list
}
function filterPageSearchData(data) {
  let list = []
  if (data[`${mainId}PageSearch`]) {
	  JSON.parse(data[`${mainId}PageSearch`]).forEach(item => {
	    let obj = {}
	    if (item) {
		    for (let key in item) {
		      if ($(`[itemid=${key}]`).attr("isprikey") == "true") obj[key] = item[key]
		    }
		  }
	    list.push(obj)
	  })
  }
  return JSON.stringify(list)
}
function uploadFileAfter(data) {
  $("#uploadFileModal .btn-outline-secondary").click()
}
function serverAfter(data) {
  setFormData(data)
  SF.setServerExecute(true)
}
function printAfter(data, itemId, showPDF) {
	if(data.WF_PRINTFILEID !="" && data.WF_PRINTFILEID != null){

    // 特殊需求 所有PDF文件 默认打开
    if (data.WF_PRINTFILEID.endsWith(".pdf")) showPDF = true

	  var s = data.WF_PRINTFILEID.split(",");
	  for (let x = 0; x < s.length; x++) {
		  if (s[x] && !data.i && !data.e) {
		    const path = `${apiUrl}/${mainId}${itemId}PrintFile.do?f=${s[x]}`
		    if (showPDF) {
          let tiem = new Date().getTime()
          sessionStorage.setItem(tiem, path)
		      window.open("showpdf" + getUrlSuffix() + "?time=" + tiem)
		    } else {
		      window.open(path)
		    }
		  }
	  }
	}
}
function exportAfter(data, itemId) {
  if (data.WF_PRINTFILEID && !data.i && !data.e) {
    const pdf = `${apiUrl}/${mainId}${itemId}ExportFile.do?e=${data.WF_PRINTFILEID}`
    window.open(pdf)
  }
}
function initPageAfter(data) {
  relData = data
  setFormData(data)
  for (let item of pageEvents) eval(item)
  if (searchBtnItemId) $(`#${searchBtnItemId}`).click()
}
function initPopAfter(data) {
  $("[id^='pop_input_']").each(function() {
    let id = $(this).attr("id").slice(10)
    let name = $(this).attr("id")
    if (data && data[id]) {
      if ($(this).is("input")) {
        $(this).val(data[id])
      }
      if ($(this).is("select")) {
        let elms = JSON.parse(data[id])
        let vals = JSON.parse(data[id + "_INDEX"])
        for (let x = 0; x < elms.length; x++) {
          $("<option>", {text: elms[x], value: vals[x]}).appendTo($(this))
        }
      }
      if ($(this).is(".radio")) {
        let elms = JSON.parse(data[id])
        let vals = JSON.parse(data[id + "_INDEX"])
        for (let x = 0; x < elms.length; x++) {
          let div = $("<div>", {class: "form-check form-check-inline", style: "margin-right: 1rem;"})
          let input = $("<input>", {type: "radio", name, value: vals[x], class: "form-check-input"})
          let label = $("<label>", {class: "form-check-label", text: elms[x]})
          div.append(input, label).appendTo($(this).parent())
        }
      }
    }
  })
}
function popSearchAfter(data, itemId) {
  let popData = []
  for (let key in data) popData = eval("JSON.parse(data." + key + ")")
  initTablePop(popData, $(`#pop_modal_${itemId}`).find("table"), itemId)
  $(`#pop_modal_${itemId}`).find("table").show()
  $(`#pop_modal_${itemId}`).find(".tableFooter").show()
}
function popFilter(index, upperItemId) {
  let formData = getFormData()
  if (index != 0) formData["row"] = index
  let url = apiUrl + "/" + mainId + upperItemId + "Filter.do"
  ajax(url, formData, `popFilterAfter(data, ${index})`)
}
function popFilterAfter(data, index) {
  for (key in data) {
    if (data[key] && key.indexOf("_INDEX") == -1) {
      let opts = JSON.parse(data[key])
      let vals = JSON.parse(data[key + "_INDEX"])
      let elm = $("#" + key + (index == 0 ? "" : index))
      let elms = []
      if (elm.length == 0 && index == 0) {
        for (let relKey in relData) {
          if (key == relKey) {
            relData[relKey] = data[key]
            relData[relKey+"_INDEX"] = data[key+"_INDEX"]
            $(`select[id^='${key}']`).each(function() {
              elms.push($(this))
            })
          }
        }
      } else {
        elms.push(elm)
      }
      for (let elm of elms) {
        elm = $(elm)
        let value = ""
        let oldValue = elm.attr("filter_value")
        if (elm.attr("mustcheckflg") == 1 || elm.attr("mustcheckflg") == 2) {
          elm.children().remove()
        } else {
          elm.children().not(":first").remove()
        }
        for (let x = 0; x < opts.length; x++) {
          let opt = $("<option>")
          opt.html(opts[x])
          opt.attr("value", vals[x])
          elm.append(opt)
          if (oldValue == vals[x]) value = vals[x]
        }
        if (value == "") value = elm.children(":first").val()
        elm.val(value)
        elm.trigger("change")
        elm.attr("filter_value", value)
      }
    }
  }
}
function popFilterService(index, upperItemId, funName) {
  let formData = getFormData()
  if (index != 0) formData["row"] = index
  let url = apiUrl + "/" + mainId + upperItemId + "Filter.do"
  ajax(url, formData, `popFilterServiceAfter(data, ${index}, "${funName}")`)
}
function popFilterServiceAfter(data, index, funName) {
  for (key in data) {
    if (data[key] && key.indexOf("_INDEX") == -1) {

      let opts = JSON.parse(data[key])
      let vals = JSON.parse(data[key + "_INDEX"])
      let elm = $("#" + key + (index == 0 ? "" : index))
      let elms = []
      if (elm.length == 0 && index == 0) {
        for (let relKey in relData) {
          if (key == relKey) {
            relData[relKey] = data[key]
            relData[relKey+"_INDEX"] = data[key+"_INDEX"]
            $(`select[id^='${key}']`).each(function() {
              elms.push($(this))
            })
          }
        }
      } else {
        elms.push(elm)
      }

      for (let elm of elms) {
        elm = $(elm)
        let value = ""
        let oldValue = elm.attr("filter_value")
        if (elm.attr("mustcheckflg") == 1 || elm.attr("mustcheckflg") == 2) {
          elm.children().remove()
        } else {
          elm.children().not(":first").remove()
        }
        for (let x = 0; x < opts.length; x++) {
          let opt = $("<option>")
          opt.html(opts[x])
          opt.attr("value", vals[x])
          elm.append(opt)
          if (oldValue == vals[x]) value = vals[x]
        }
        if (value == "") value = elm.children(":first").val()
        elm.val(value)
        elm.trigger("change")
        elm.attr("filter_value", value)
      }
    }
  }
  let url = apiUrl + "/" + funName + ".do"
  let formData = getFormData()
  formData["row"] = index
  ajax(url, formData, "serverAfter(data)")
}
function popInput(index, value, itemId, upperItemId) {
  let url = apiUrl + "/" + mainId + upperItemId + "PopSearchByName.do"
  let formData = {}
  formData[itemId.substring(1, itemId.length)] = value
  ajax(url, formData, `popInputAfter(data, ${index}, "${itemId}")`)
}
function popInputAfter(data, index, itemId) {
  for (id in data) {
    let elm = $("#" + id + (index == 0 ? "" : index)).val(data[id])
    if (id != itemId) elm.trigger("change")
  }
}
function referText(index, value, itemId, upperItemId) {
  let url = apiUrl + "/" + mainId + upperItemId + "AutoComplete.do"
  let formData = {}
  formData[itemId] = value
  ajax(url, formData, `referTextAfter(data, "${value}", ${index}, "${itemId}")`)
}
function referTextAfter(data, value, index, itemId) {
  $("#list" + itemId).children().not(":first").remove()
  for (let item of data) {
    let option = $("#list" + itemId).children("option").first().clone()
    option.val(item.value)
    option.text(item.label)
    if (value == item.label) {
      for (key in item) {
        if (key != "id" && key != "label" && key != "value") {
          $("#" + key.slice(1) + (index == 0 ? "" : index)).val(item[key]).trigger("change")
        }
      }
    }
    $("#list" + itemId).append(option)
  }
}
function referChangeAfter(data, index) {
  for (let key in data) {
    $("#" + key + (index == 0 ? "" : index)).val(data[key])
  }
}
function initMenuAction() {
  $(".menu-inner").find(".menu-item").each(function() {
    $(this).removeClass("active")
    if ($(this).find("a").attr("data-mainId") == mainId) {
      $(this).addClass("active")
      $(this).parents(".menu-item").addClass("open")
      $(this).parents(".menu-item").addClass("active")
    }
  })
}
function initMenu() {
  let url = apiUrl + "/getMenu.do"
  ajax(url, null, "initMenuAfter(data)")
}
function initMenuAfter(data) {
  const filterMenu = (fatherId) => {
    let list = []
    for (let menu of data.roles) {
      if (menu.userMenuEntity.displayflg != 1) continue
      if (menu.userMenuEntity.father_ID == fatherId) {
        list.push({
          name: menu.userMenuEntity.pfofile_NM,
          mainId: menu.userMenuEntity.page_MNG_ID,
          transflg: menu.userMenuEntity.transflg,
          children: filterMenu(menu.name)
        })
      }
    }
    return list
  }
  const buildMenu = (data, father) => {
    for (let item of data) {
      let menu = $("<li>", {class: "menu-item"}).appendTo(father)
      let link = $("<a>", {class: "menu-link"}).appendTo(menu)
      $("<div>", {text: item.name}).appendTo(link)
      if (item.children && item.children.length) {
        menu.addClass("e_sub")
        link.addClass("menu-toggle")
        let sub = $("<ul>", {class: "menu-sub"}).appendTo(menu)
        buildMenu(item.children, sub)
      } else {
        menu.addClass("e_link")
        link.attr("data-mainId", item.mainId)
        if (mainId == item.mainId || mainId == item.mainId + "s") {
          menu.addClass("active")
          menu.parents("li.menu-item").addClass("active open")
        }
        link.on("click", function(e) {
          e.preventDefault()
          if (item.mainId) {
            let url = item.mainId ? item.mainId : ""
            url += item.transflg == 1 ? "s" : ""
            url += window.location.href.indexOf(".html") != -1 ? ".html" : ""
            window.location.href = url
          } else {
            alert("遷移先画面はありません")
          }
        })
      }
    }
  }
  let list = data && data.roles ? filterMenu("") : []
  if (list.length == 0) list.push({ name: "TOP" })
  buildMenu(list, $(".menu-inner"))
  if (displayFrameFlg == 2) initMenuAction()
}
function initTablePop(data, table, itemId) {
  let thead = table.find("thead")
  let tbody = table.find("tbody")

  let nav = table.siblings(".tableFooter").find(".tableNav")
  let pagination = nav.find(".pagination")
  let tablePage = parseInt($("#currentpage").val()) || 1
  let tableSize = 10

  tbody.empty()
  pagination.empty()

  const buildItem = function(text) {
    let pageItem = $("<li>", {class: "page-item"}).appendTo(pagination)
    let pageLink = $("<a>", {class: "page-link"}).appendTo(pageItem)
    if (text == "prev") {
      $("<i>", {class: "tf-icon bx bx-chevron-left"}).appendTo(pageLink)
      pageItem.on("click", function(e) {
        if (tablePage - 1 > 0) {
          $("#currentpage").val(tablePage - 1)
          nav.find(".active").removeClass("active").prev().addClass("active")
          initTablePop(data, table, itemId)
        }
      })
    }
    if (text == "next") {
      $("<i>", {class: "tf-icon bx bx-chevron-right"}).appendTo(pageLink)
      pageItem.on("click", function(e) {
        if (tablePage < Math.ceil(data.length / tableSize)) {
          $("#currentpage").val(tablePage + 1)
          nav.find(".active").removeClass("active").next().addClass("active")
          initTablePop(data, table, itemId)
        }
      })
    }
    if (text == "……") {
      pageLink.text(text)
    }
    if (Number.isInteger(text)) {
      if (text == tablePage) pageItem.addClass("active");
      pageLink.text(text)
      pageItem.on("click", function(e) {
        $("#currentpage").val(text)
        pageItem.addClass("active").siblings().removeClass("active")
        initTablePop(data, table, itemId)
      })
    }
  }

  let pageNum = Math.ceil(data.length / tableSize)

  let pageStart = 1
  let pageEnd = Math.min(10, pageNum)

  buildItem("prev")
  if (tablePage > 9) {
    buildItem(1)
    buildItem(2)
    buildItem("……")
    pageStart = tablePage - 5
    pageEnd = Math.min(tablePage + 4, pageNum)
  }
  for (let i = pageStart; i <= pageEnd; i++) buildItem(i)
  if (pageNum > pageEnd) {
    buildItem("……")
    buildItem(pageNum)
  }
  buildItem("next")

  let i = (tablePage - 1) * tableSize
  let l = Math.min(i + tableSize, data.length)
  for (; i < l; i++) {
    let item = data[i]
    let tr = $("<tr>").appendTo(tbody)
    $("<td>", {text: tbody.find("tr").length}).appendTo(tr)
    for (key in item) {
      $("<td>", {text: item[key]}).appendTo(tr)
    }
    let btn_sel = $("<button>", {class: "btn btn-sm btn-primary"})
    btn_sel.attr("data-bs-dismiss", "modal")
    btn_sel.text("選択")
    btn_sel.on("click", function(e) {
      e.preventDefault()
      let index = $("#pop_modal_" + itemId).attr("fromIndex")
      if (index != -1) {
        for (key in item) {
          let elmId = table.find("th[itemId='" + key + "']").attr("mapItemId")
          $(`#${elmId}${index}`).val(item[key]).trigger("change")
        }
      } else {
        for (key in item) {
          let elmId = table.find("th[itemId='" + key + "']").attr("mapItemId")
          $(`#${elmId}`).val(item[key]).trigger("change")
        }
      }
    })
    $("<td>").append(btn_sel).appendTo(tr)
  }
}
function initTableForSearchPage(data, table) {

  let thead = table.find("thead")
  let tbody = table.find("tbody")

  let nav = table.siblings(".tableFooter").find(".tableNav")
  let pagination = nav.find(".pagination")
  let tablePage = parseInt($("#currentpage").val()) || 1
  let tableSize = parseInt($("#pageRcds").val()) || 10
  $("#currentpage").val(tablePage)

  tbody.empty()
  pagination.empty()

  const buildItem = function(text) {
    let pageItem = $("<li>", {class: "page-item"}).appendTo(pagination)
    let pageLink = $("<a>", {class: "page-link"}).appendTo(pageItem)
    if (text == "prev") {
      $("<i>", {class: "tf-icon bx bx-chevron-left"}).appendTo(pageLink)
      pageItem.on("click", function(e) {
        if (tablePage - 1 > 0) {
          $("#currentpage").val(tablePage - 1)
          nav.find(".active").removeClass("active").prev().addClass("active")
          initTableForSearchPage(data, table)
        }
      })
    }
    if (text == "next") {
      $("<i>", {class: "tf-icon bx bx-chevron-right"}).appendTo(pageLink)
      pageItem.on("click", function(e) {
        if (tablePage < Math.ceil(data.length / tableSize)) {
          $("#currentpage").val(tablePage + 1)
          nav.find(".active").removeClass("active").next().addClass("active")
          initTableForSearchPage(data, table)
        }
      })
    }
    if (text == "……") {
      pageLink.text(text)
    }
    if (Number.isInteger(text)) {
      if (text == tablePage) pageItem.addClass("active");
      pageLink.text(text)
      pageItem.on("click", function(e) {
        $("#currentpage").val(text)
        pageItem.addClass("active").siblings().removeClass("active")
        initTableForSearchPage(data, table)
      })
    }
  }

  let pageNum = Math.ceil(data.length / tableSize)

  let pageStart = 1
  let pageEnd = Math.min(10, pageNum)

  buildItem("prev")
  if (tablePage > 9) {
    buildItem(1)
    buildItem(2)
    buildItem("……")
    pageStart = tablePage - 5
    pageEnd = Math.min(tablePage + 4, pageNum)
  }
  for (let i = pageStart; i <= pageEnd; i++) buildItem(i)
  if (pageNum > pageEnd) {
    buildItem("……")
    buildItem(pageNum)
  }
  buildItem("next")
  

  let i = (tablePage - 1) * tableSize
  let l = Math.min(i + tableSize, data.length)
  for (; i < l; i++) {
    let tr = $("<tr>").appendTo(tbody)
    $("<td>", {text: i + 1}).appendTo(tr)
    thead.find("th:not(:first-child").each(function() {
      let td = $("<td>").appendTo(tr)
      let kind = $(this).attr("kind")
      let regex = $(this).attr("regex")
      let itemId = $(this).attr("itemId")
      if (kind == 5) {
        let value = data[i][itemId]
        if ($("#" + itemId).is("select")) {
          $("<input>", {type: "hidden", value}).appendTo(td)
          value = $("#" + itemId).find("option[value='" + value + "']").text()
        }
        let readonly = true
        let elm = $("<input>", {type: "text", value, readonly, regex}).appendTo(td)
        elm.css({"border": "none", "background-color": "unset"})
        elm.addClass("form-control")
        elm.trigger("change")
      }
      if (kind == -1) {
        if ($(this).attr("icon") == "edit") {
          let elm = $("<i class='bx bxs-edit'></i>").css("cursor", "pointer").appendTo(td)
          let index = i
          elm.on("click", function(e) {
            e.preventDefault()
            let tr = $(this).parents("tr")
            let kvs = []
            $(this).parents("table").find("thead th").each(function() {
              let index = $(this).index()
              let key = $(this).attr("itemid")
              let td = tr.find("td").eq(index)
              let value = td.find("input[type='hidden']").val() || td.find("input").val()
              if ($(this).attr("isprikey") == "true") kvs.push({key, value})
            })
            let url = mainId
            url += getUrlSuffix()
            url += "?d=" + window.btoa(encodeURIComponent("kvs=" + JSON.stringify(kvs) + "&mode=1&actflg=2"))
            sessionStorage.setItem("index", index)
            window.location.href = url
          })
        } else {
          let elm = $("<i class='bx bxs-trash'></i>").css("cursor", "pointer").appendTo(td)
          elm.on("click", function(e) {
            e.preventDefault()
            let delData = {}
            elm.parents("table").find("th").each(function() {
              if ($(this).attr("isprikey") == "true") {
                let itemId = $(this).attr("itemId")
                let td = elm.parents("tr").find("td").eq($(this).index())
                let value = td.find("input[type='hidden']").val() || td.find("input").val()
                delData[itemId] = value
              }
            })
            let url = apiUrl + "/" + mainId + "DeletePageSearch.do"
            let data = ajax(url, delData, "deletePageSearchAfter()")
          })
        }
      }
    })
  }

  let start = ((tablePage - 1) * tableSize + 1)
  let end = start + tableSize - 1
  let total = data.length
  if (end > total) end = total
  if (total > 0) {
    $(".tableTips").html("Viewing Rows " + start + " - " + end + " of " + total)
  } else {
    $(".tableTips").html("検索対象のデータが存在しません。")
    setTimeout(function() {
      alert("検索対象のデータが存在しません。")
    }, 500)
  }
}
function initCustomTable(data) {
  if (data.v) {
    let v = data.v
    let thead = $("table").find("thead")
    let tbody = $("table").find("tbody").empty()
    let tr = thead.find("tr").empty()
    let columns = v.columnNames || []
    let properts = v.columnProperties || []
    for (let i = 0; i < columns.length; i++) {
      let th = $("<th>", {text: columns[i], }).appendTo(tr)
      th.css("text-align", properts[i].alignment)
    }
    let list = v.data || []
    for (let item of list) {
      tr = $("<tr>").appendTo(tbody)
      for (let i = 0; i < item.length; i++) {
        let td = $("<td>", {text: item[i]}).appendTo(tr)
        td.css("text-align", properts[i].alignment)
      }
    }
  }
}
function addRowForTableStatic(table, data) {
  let tbody = table.find("tbody")
  let subId = table.attr("subid")
  let trL = tbody.find("tr").length
  let tempL = table.find(".tempTr").length
  let index = trL / tempL
  table.find(".tempTr").each(function() {
    let tr = $(this).clone()
    tr.find("input, select, textarea").each(function() {
      let id = $(this).attr("id")
      $(this).attr("id", id + index)
      if ($(this).is("select") && relData && relData[id]) {
        let opts = JSON.parse(relData[id])
        let vals = JSON.parse(relData[`${id}_INDEX`])
        let defVal = relData[id + "_DEFAULT"]
        if (!isEmpty(defVal)) $(this).val(defVal)
        let freefld28 = $(this).attr("freefld28")
        if (freefld28) {
          $(this).on("change", function() {
            let index = $(this).parents("tr").index() + 1
            let text = $(this).find("option:selected").text()
            $("#" + freefld28 + index).val(text).trigger("change")
          })
        }
      }
      if (data && !isEmpty(data[id])) {
        $(this).attr("value", data[id])
        $(this).val(data[id])
      }
    })

    tr.removeClass("tempTr")
    tr.addClass(`rowgrid${subId}${index}`)
    tr.appendTo(tbody)
    tr.show()
    
    if (data) {
      tr.attr("gridOpFlag", -1)
      tr.on("change", "input, select, textarea, radio", function() {
        $(`.rowgrid${subId}${index}`).attr("gridOpFlag", 1)
      })
    } else {
      tr.attr("gridOpFlag", 2)
    }
  })
}
function addRowForTable(table, data) {

  let thead = table.find("thead")
  let tbody = table.find("tbody")
  let subid = table.attr("subid")
  let index = tbody.find("tr").length + 1

  let tr = $("<tr>", {id: `rowgrid${subid}${index}`}).appendTo(tbody)
  if (data) {
    tr.attr("gridOpFlag", -1)
    tr.on("change", "input, select, textarea, radio", function() {
      tr.attr("gridOpFlag", 1)
    })
  } else {
    tr.attr("gridOpFlag", 2)
  }
  
  if (table.attr("rowDel") != 0) {
    $("<td>").append($("<input>", {type: "checkbox", class: "form-check-input"})).appendTo(tr)
  } else {
    $("<td>", {text: index}).appendTo(tr)
  }

  thead.find("th:not(:first-child").each(function() {
    let td = $("<td>").appendTo(tr)
    let kind = $(this).attr("kind")
    let itemId = $(this).attr("itemId")
    let labelAlign = $(this).attr("labelAlign")
    let readonly = $(this).attr("readonly")
    let subid = $(this).attr("subid") + index
    let regex = $(this).attr("data-regex")
    let regexkind = $(this).attr("data-regexkind")
    let id = itemId + index
    let name = itemId
    let freefld28 = $(this).attr("freefld28")
    let defaulvalue = $(this).attr("defaulvalue")
    let _checked = $(this).attr("_checked")
    let _uncheck = $(this).attr("_uncheck")
    let mustcheckflg = $(this).attr("mustcheckflg")

    if (kind == 2) {
      let select = $("<select>", {class: "form-select", id, name, subid, mustcheckflg}).appendTo(td)
      $("<option>", {value: null, text: null}).appendTo(select)
      if (relData && relData[itemId]) {
        let opts = JSON.parse(relData[itemId])
        let vals = JSON.parse(relData[`${itemId}_INDEX`])
        for (let i = 0; i < opts.length; i++) {
          $("<option>", {value: vals[i], text: opts[i]}).appendTo(select)
        }
        if (relData[itemId + "_DEFAULT"]) select.val(relData[itemId + "_DEFAULT"])
        if (mustcheckflg == 1 || mustcheckflg == 2) {
          select.find("option:first").remove()
          if (!data) select.trigger("change")
        }
      }
      if (data) select.val(data[itemId]).trigger("change")
      if (readonly) select.attr("disabled", true)

      if (freefld28) {
        select.on("change", function() {
          let index = $(this).parents("tr").index() + 1
          let text = select.find("option:selected").text()
          $("#" + freefld28 + index).val(text).trigger("change")
        })
      }
    }

    if (kind == 3) {
      if (relData && relData[itemId]) {
        let elms = JSON.parse(relData[itemId])
        let vals = JSON.parse(relData[itemId + "_INDEX"])
        let hidden = $("<input>", {type: "hidden", name}).appendTo(td)
        for (let x = 0; x < elms.length; x++) {
          let div = $("<div>", {class: "form-check form-check-inline"})
          name += index
          let input = $("<input>", {type: "radio", name, value: vals[x], class: "form-check-input"})
          let label = $("<label>", {class: "form-check-label", text: elms[x]})
          div.append(input, label).appendTo(td)
          if (freefld28) {
            input.on("click", function() {
              hidden.val(vals[x]).trigger("change")
              $("#" + freefld28 + index).val(elms[x]).trigger("change")
            })
          }
        }
      }
    }

    if (kind == 4) {
      let input = $("<input>", {type: "checkbox", id, name, class: "form-check-input"}).appendTo(td)
      input.attr("_checked", _checked)
      input.attr("_uncheck", _uncheck)
      if (relData && relData[id] == "1") input.attr("checked", "checked")
    }

    if ([5, 7, 9, 14, 17].includes(parseInt(kind))) {
      let input = $("<input>", {class: "form-control", type: "text", id, name, subid, readonly }).appendTo(td)
      if (regex) input.attr("regex", regex)
      if (regexkind) input.attr("regexkind", regexkind)
      if (!readonly && kind == 9 || kind == 17) initDatePicker(id)
      if (labelAlign == 2) input.css("text-align", "center")
      if (labelAlign == 3) input.css("text-align", "right")
      if (kind == 7) input.val("[自動採番]").attr("disabled", "disabled")
      if (defaulvalue) input.val(defaulvalue)
      if (relData && relData[itemId]) input.val(relData[itemId])
      if (data && data[itemId]) input.val(data[itemId])
      if (data && $(this).attr("isprikey") == "true") readonly = true
    }

    if (kind == 18) {
      let input = $("<input>", {class: "form-control", type: "password", id, name, subid, readonly }).appendTo(td)
      if (labelAlign == 2) input.css("text-align", "center")
      if (labelAlign == 3) input.css("text-align", "right")
      if (defaulvalue) input.val(defaulvalue)
      if (relData && relData[itemId]) input.val(relData[itemId])
      if (data && data[itemId]) input.val(data[itemId])
    }

    if (kind == 10) {
      $(this).css({"text-align": "center", "width": "120px"})
      $("<input>", {tyep: "hidden", id}).appendTo(td)
      let button = $("<button>", {text: "uploadFile", class: "btn btn-sm btn-secondary"}).appendTo(td)
      button.on("click", function(e) {
        e.preventDefault()
        let fileInput = $("<input>", { type: "file" })
        fileInput.on("change", function() {
          let formData = new FormData()
          formData.append("imagesGRIDIMAGEUPLOAD", fileInput[0].files[0])
          let url = apiUrl + "/view/uploadimage" + mainId + "GRIDIMAGEUPLOAD.do"
          ajax(url, formData, `upImgAfter(data, "${id}")`, false)
        })
        fileInput.click()
      })
    }

    if (kind == 11 || kind == 12) {
      let text = $(this).text()
      let style = $(this).attr("data-style")
      let _class = $(this).attr("data-class")
      $("<button>", {id, name, text, style, class: _class}).appendTo(td)
      td.css("border-left", "1px solid #d9dee3")
    }

    if (kind == 19) {
      let input = $("<input>", {class: "form-control", type: "text", id, name, readonly}).appendTo(td)
      input.attr("list", "list" + itemId)
      if (data) input.val(data[itemId])
      let datalist = $("<datalist>", {id: "list" + itemId}).appendTo(td)
      let option = $("<option>").appendTo(datalist)
      if (labelAlign == 2) input.css("text-align", "center")
      if (labelAlign == 3) input.css("text-align", "right")
    }

    if (kind == 22) {
      let value = data ? data[itemId] : null
      let hideI = $("<input>", {type: "hidden", value, id, name}).appendTo(td)
      id = "o" + id
      name = "o" + name
      value = data ? data[name] : null
      let input = $("<input>", {class: "form-control", type: "text", id, name, value, readonly}).appendTo(td)
      if (!readonly) {
        let img = $("<img>", {src: "../static/img/search.gif", name: "pop_img_" + itemId})
        img.css({"margin-right": "-20px", "padding": "5px", "cursor": "pointer"})
        img.attr("data-bs-toggle", "modal")
        img.attr("data-bs-target", "#pop_modal_" + itemId)
        img.appendTo(td)
        img.on("click", function(e) {
          e.preventDefault()
          $("#pop_modal_" + itemId).attr("fromIndex", $(this).parents("tr").index() + 1)
          $("#pop_modal_" + itemId + "_search").click()
        })
      }
      td.find("input").css("width", "calc(100% - 35px)")
      if (labelAlign == 2) input.css("text-align", "center")
      if (labelAlign == 3) input.css("text-align", "right")
    }

    if ($(this).is(":hidden")) td.css("display", "none")
  })

  $(tr).find("input").trigger("change")
}
function initTableStatic(table, data) {
  let subid = table.attr("subid")
  let key = "dragB" + subid
  if (tableData[key]) {
    table.find("tbody tr:not(.tempTr)").each(function() {
      let item = data.find(item => item.rowindex == $(this).index() + 1) || {}
      for (let name in item) {
        let elm = $(this).find(`input[name=${name}]`)
        if (elm.length) elm.val(item[name]).trigger("change")
      }
    })
  } else {
    tableData[key] = data
    table.find("tbody tr:not(.tempTr)").remove()
    let nav = table.siblings(".tableFooter").find(".tableNav")
    let tablePage = parseInt($("#currentpage").val()) || 1
    let tableSize = parseInt($("#pageRcds").val())

    if (tableSize > 0) {

      let subId = table.attr("subid")
      let events = tableEvents.filter(item => item.subId == subId)

      let i = (tablePage - 1) * tableSize
      let l = Math.min(i + tableSize, data.length)
      for (; i < l; i++) addRowForTableStatic(table, data[i])

      let pagination = nav.find(".pagination").empty()

      const buildItem = function(text) {
        let pageItem = $("<li>", {class: "page-item"}).appendTo(pagination)
        let pageLink = $("<a>", {class: "page-link"}).appendTo(pageItem)
        if (text == "prev") {
          $("<i>", {class: "tf-icon bx bx-chevron-left"}).appendTo(pageLink)
          pageItem.on("click", function(e) {
            if (tablePage - 1 > 0) {
              $("#currentpage").val(tablePage - 1)
              if (events.length) for (let event of events[0].beforePaging) eval(event)
              nav.find(".active").removeClass("active").prev().addClass("active")
              let data = tableData[key]
              tableData[key] = null
              initTable(table, data)
            }
          })
        }
        if (text == "next") {
          $("<i>", {class: "tf-icon bx bx-chevron-right"}).appendTo(pageLink)
          pageItem.on("click", function(e) {
            if (tablePage < Math.ceil(data.length / tableSize)) {
              $("#currentpage").val(tablePage + 1)
              if (events.length) for (let event of events[0].beforePaging) eval(event)
              nav.find(".active").removeClass("active").next().addClass("active")
              let data = tableData[key]
              tableData[key] = null
              initTable(table, data)
            }
          })
        }
        if (text == "……") {
          pageLink.text(text)
        }
        if (Number.isInteger(text)) {
          if (text == tablePage) pageItem.addClass("active");
          pageLink.text(text)
          pageItem.on("click", function(e) {
            $("#currentpage").val(text)
            if (events.length) for (let event of events[0].beforePaging) eval(event)
            pageItem.addClass("active").siblings().removeClass("active")
            let data = tableData[key]
            tableData[key] = null
            initTable(table, data)
          })
        }
      }

      let pageNum = Math.ceil(data.length / tableSize)
      
      let pageStart = 1
      let pageEnd = Math.min(10, pageNum)

      buildItem("prev")
      if (tablePage > 9) {
        buildItem(1)
        buildItem(2)
        buildItem("……")
        pageStart = tablePage - 5
        pageEnd = Math.min(tablePage + 4, pageNum)
      }
      for (let i = pageStart; i <= pageEnd; i++) buildItem(i)
      if (pageNum > pageEnd) {
        buildItem("……")
        buildItem(pageNum)
      }
      buildItem("next")

      let start = ((tablePage - 1) * tableSize + 1)
      let end = start + tableSize - 1
      let total = data.length
      if (end > total) end = total
      if (total > 0) {
        $(".tableTips").html("Viewing Rows " + start + " - " + end + " of " + total)
      } else {
        $(".tableTips").html("検索対象のデータが存在しません。")
      }
      if (events.length) for (let event of events[0].afterPaging) eval(event)
    } else {
      let start = 0
      let end = data.length
      let total = data.length
      for (let i = 0; i < total; i++) addRowForTableStatic(table, data[i])
      if (total > 0) {
        $(".tableTips").html("Viewing Rows " + start + " - " + end + " of " + total)
      } else {
        $(".tableTips").html("検索対象のデータが存在しません。")
      }
    }
  }
}
function initTable(table, data) {
  let subid = table.attr("subid")
  let key = "dragB" + subid
  if (tableData[key]) {
    table.find("tbody tr").each(function() {
      let item = data.find(item => item.rowindex == $(this).index() + 1) || {}
      for (let name in item) {
        let elm = $(this).find(`input[name=${name}]`)
        if (elm.length) elm.val(item[name]).trigger("change")
      }
    })
  } else {
    tableData[key] = data
    table.find("tbody").empty()
    let nav = table.siblings(".tableFooter").find(".tableNav")
    let tablePage = parseInt($("#currentpage").val()) || 1
    let tableSize = parseInt($("#pageRcds").val())

    if (tableSize > 0) {

      let subId = table.attr("subid")
      let events = tableEvents.filter(item => item.subId == subId)

      let i = (tablePage - 1) * tableSize
      let l = Math.min(i + tableSize, data.length)
      for (; i < l; i++) addRowForTable(table, data[i])

      let pagination = nav.find(".pagination").empty()

      const buildItem = function(text) {
        let pageItem = $("<li>", {class: "page-item"}).appendTo(pagination)
        let pageLink = $("<a>", {class: "page-link"}).appendTo(pageItem)
        if (text == "prev") {
          $("<i>", {class: "tf-icon bx bx-chevron-left"}).appendTo(pageLink)
          pageItem.on("click", function(e) {
            if (tablePage - 1 > 0) {
              $("#currentpage").val(tablePage - 1)
              if (events.length) for (let event of events[0].beforePaging) eval(event)
              nav.find(".active").removeClass("active").prev().addClass("active")
              let data = tableData[key]
              tableData[key] = null
              initTable(table, data)
            }
          })
        }
        if (text == "next") {
          $("<i>", {class: "tf-icon bx bx-chevron-right"}).appendTo(pageLink)
          pageItem.on("click", function(e) {
            if (tablePage < Math.ceil(data.length / tableSize)) {
              $("#currentpage").val(tablePage + 1)
              if (events.length) for (let event of events[0].beforePaging) eval(event)
              nav.find(".active").removeClass("active").next().addClass("active")
              let data = tableData[key]
              tableData[key] = null
              initTable(table, data)
            }
          })
        }
        if (text == "……") {
          pageLink.text(text)
        }
        if (Number.isInteger(text)) {
          if (text == tablePage) pageItem.addClass("active");
          pageLink.text(text)
          pageItem.on("click", function(e) {
            $("#currentpage").val(text)
            if (events.length) for (let event of events[0].beforePaging) eval(event)
            pageItem.addClass("active").siblings().removeClass("active")
            let data = tableData[key]
            tableData[key] = null
            initTable(table, data)
          })
        }
      }

      let pageNum = Math.ceil(data.length / tableSize)
      
      let pageStart = 1
      let pageEnd = Math.min(10, pageNum)

      buildItem("prev")
      if (tablePage > 9) {
        buildItem(1)
        buildItem(2)
        buildItem("……")
        pageStart = tablePage - 5
        pageEnd = Math.min(tablePage + 4, pageNum)
      }
      for (let i = pageStart; i <= pageEnd; i++) buildItem(i)
      if (pageNum > pageEnd) {
        buildItem("……")
        buildItem(pageNum)
      }
      buildItem("next")

      let start = ((tablePage - 1) * tableSize + 1)
      let end = start + tableSize - 1
      let total = data.length
      if (end > total) end = total
      if (total > 0) {
        $(".tableTips").html("Viewing Rows " + start + " - " + end + " of " + total)
      } else {
        $(".tableTips").html("検索対象のデータが存在しません。")
      }
      if (events.length) for (let event of events[0].afterPaging) eval(event)
    } else {
      let start = 0
      let end = data.length
      let total = data.length
      for (let i = 0; i < total; i++) addRowForTable(table, data[i])
      if (total > 0) {
        $(".tableTips").html("Viewing Rows " + start + " - " + end + " of " + total)
      } else {
        $(".tableTips").html("検索対象のデータが存在しません。")
      }
    }
  }
}
function upImgAfter(data, itemId) {
  if (data && data.ATTACHID) {
    let elm = $(`#${itemId}`)
    elm.val(data.ATTACHID).trigger("change")
  }
}
function initDatePicker(itemId) {
  $(`#${itemId}`).datepicker({
    changeYear: true,
    changeMonth: true,
    showButtonPanel: true,
    dateFormat: "yy/mm/dd",
    closeText: "閉じる",
    currentText: "今日",
    dayNamesMin: ["日", "月", "火", "水", "木", "金", "土"],
    monthNamesShort: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"]
  })
}
function initCalendar(_year) {
  _year = _year || new Date().getFullYear()
  let calendar = $(".calendar").empty()
  for (let _month = 0; _month < 13; _month++) {
    let row = $("<div>", {class: "row"}).appendTo(calendar)
    let l = 0
    if ([0, 1, 3, 5, 7, 8, 10, 12].includes(_month)) l = 31
    if ([4, 6, 9, 11].includes(_month)) l = 30
    if (_month == 2) l = _year % 4 == 0 ? 29 : 28
    for (let _day = 0; _day < 32; _day++) {
      if (_day == 0) {
        let content = _month == 0 ? "" : _month + "月"
        $("<div>").css({"width": "60px", "text-align": "right"}).append(content).appendTo(row)
      } else {
        let div = $("<div>").css({"width": "30px", "text-align": "center"}).appendTo(row)
        let content = null
        if (_month == 0) {
          content = _day
        } else {
          let _date = _year + "/" + _month + "/" + _day
          let _weekday = new Date(_date).getDay()
          let _holiday = 0
          let input = $("<input>", {
            type: "checkbox",
            name: "calendarDay",
            _weekday, 
            _year, 
            _month, 
            _day,
            _date,
            _holiday,
          })
          input.on("click", function() {
            $(this).attr("_holiday", $(this).is(":checked") ? 1 : 0)
            $(this).attr("_finaholiday", $(this).is(":checked") ? 1 : 0)
          })
          input.css("cursor", "pointer")
          content = input
          if (_day > l) {
            input.css("opacity", 0)
            input.attr("disabled", "disabled")
            input.removeAttr("name")
            input.removeAttr("_weekday")
            input.removeAttr("_year")
            input.removeAttr("_month")
            input.removeAttr("_day")
            input.removeAttr("_date")
            input.removeAttr("_holiday")
          } else {
            if (_weekday == 6) div.css("background", "#EAFAF1")
            if (_weekday == 0) div.css("background", "#F9EBEA")
          }
          if (_month == 1) div.css("border-top", "1px solid #D5D8DC")
          if (_day == 1) div.css("border-left", "1px solid #D5D8DC")
          div.css("border-bottom", "1px solid #D5D8DC")
          div.css("border-right", "1px solid #D5D8DC")
          div.css("padding", "10px 0")
          div.css("cursor", "pointer")
          div.hover(function() {
          }, function() {
          })
        }
        div.append(content)
      }
    }
  }
}
function deletePageSearchAfter() {
  let trl = $("table tbody tr").length
  let tablePage = $(".page-item.active a").html() || 1
  if (trl == 1 && tablePage > 1) $(".page-item.active").removeClass("active").prev().addClass("active")
  $("#btn_search").click()
}
function doshowcalendar() {
  let upperItemId = $("#form1 div.calendar").attr("upperitemid")
  let freeFld29 = $("#form1 div.calendar").attr("freefld29")
  initCalendar($("#" + freeFld29).val())
  let url = apiUrl + "/" + mainId + upperItemId + "CalendarSearch.do"
  ajax(url, getFormData(), "setFormData(data)")
}
function dosavecalendar() {
  let upperItemId = $("#form1 div.calendar").attr("upperitemid")
  let url = apiUrl + "/" + mainId + upperItemId + "CalendarSave.do"
  ajax(url, getFormData(), "setFormData(data)")
}
function isEmpty(val) {
    if (typeof val == "undefined") return true
    if (val === "" || val === null) return true
    return false
}
function setFormData(data) {
  if (data["mode"] && data["mode"] == 1) {
    $("input[isprikey='true']").attr("readonly", true)
  }
  let form = $("#form1").clone()
  form.find(":disabled").each(function() {
    $(this).removeAttr("disabled")
  })
  form.serializeArray().forEach(item => {
    let elm = $("#" + item.name)
    if (elm.is("select")) {
      let first = elm.find("option:first")
      let defVal = null

      if (isEmpty(first.text().trim()) && !isEmpty(first.val())) {
        defVal = first.val()
        first.val("")
      }

      if (data && data[item.name]) {
        let opts = JSON.parse(data[item.name])
        let vals = JSON.parse(data[item.name + "_INDEX"])
        for (let x = 0; x < opts.length; x++) {
          $("<option>", {text: opts[x], value: vals[x]}).appendTo(elm)
        }

        if (defVal != null) {
          elm.val(defVal).trigger("change")
          elm.attr("filter_value", defVal)
        } else {
          if (elm.attr("mustcheckflg") == 1 || elm.attr("mustcheckflg") == 2) {
            if (first.text().trim() == "") {
              first.remove()
              if (!data[item.name + "_DEFAULT"]) {
                let val = elm.find("option:first").val()
                elm.val(val).trigger("change")
                elm.attr("filter_value", val)
              }
            }
          }
        }
      }
      if (data && data[item.name + "_DEFAULT"] != undefined) {
        let val = data[item.name + "_DEFAULT"]
        elm.val(val).trigger("change")
        elm.attr("filter_value", val)
      }
      if (elm.attr("readonly")) elm.attr("disabled", "disabled")
    }
    if (elm.is("input[type!='checkbox']") && data && data[item.name] !== undefined) {
      elm.val(data[item.name]).trigger("change")
    }
    if (elm.is("textarea") && data && data[item.name] !== undefined) {
      elm.val(data[item.name])
    }
  })
  $("#form1 div.radios").each(function() {
    let id = name = $(this).attr("id")
    if (data && data[id]) {
      let opts = JSON.parse(data[id])
      let vals = JSON.parse(data[id + "_INDEX"])
      let value = data[id + "_DEFAULT"] || null
      for (let x = 0; x < opts.length; x++) {
        let div = $("<div>", {class: "form-check form-check-inline", style: "margin-right: 10px;"})
        let input = $("<input>", {class: "form-check-input", type: "radio", name, value: vals[x]})
        let label = $("<label>", {class: "form-check-label", text: opts[x]})
        if (value == vals[x]) input.attr("checked", "checked")
        div.append(input, label).appendTo($(this))
      }
    }
  })
  $("#form1 input[type='checkbox']").each(function() {
    let name = $(this).attr("name")
    if (!data[name]) return true
    let relData = $(this).attr("reldata")
    let _checked = $(this).attr("_checked") || 1
    let _uncheck = $(this).attr("_uncheck") || 0
    let readonly = $(this).attr("readonly")
    if (data[name] == _checked) $(this).attr("checked", "checked")
    if (data[name] == _uncheck) $(this).removeAttr("checked")
    $(this).val(data[name])
    if (readonly) $(this).attr("disabled", "disabled")
  })
  $("#form1 div.nvd3-svg").each(function() {
    let id = $(this).attr("id")
    if (data[id]) $(this).append(data[id])
  })
  $("#form1 div.calendar").each(function() {
    let id = $(this).attr("id")
    if (data[id]) {
      for (let item of JSON.parse(data[id])) {
        let time = new Date(item.date)
        let year = time.getFullYear()
        let month = time.getMonth() + 1
        let day = time.getDate()
        let date = year + "/" + month + "/" + day
        let input = $("input[name='calendarDay'][_date='" + date + "']")
        if (item.holiday == "1") {
          input.attr("_holiday", 1)
          input.prop("checked", true)
        }
      }
    }
  })
  $("table").each(function() {
    if (isSearchPage()) {
      let tableData = data[`${mainId}PageSearch`]
      if (tableData) {
        tableData = JSON.parse(tableData)
        initTableForSearchPage(tableData, $(".table"))
      }
    } else {
      if ($(this).is(".table-static")) {
        let subId = $(this).attr("subid")
        let tableData = data[`dragB${subId}`]
        if (tableData && subId) {
          if ($(this).attr("tablesinglemulti") == 0) {
            let data = JSON.parse(tableData)
            if (data.length > 0) {
              setFormData(data[0])
              let bodyTr = $(this).find("tbody tr")
              bodyTr.attr("gridOpFlag", -1)
              bodyTr.on("change", "input, select, textarea, radio", function() {
                bodyTr.attr("gridOpFlag", 1)
              })
            }
          } else {
            initTableStatic($(this), JSON.parse(tableData))
          }
        }
      } else {
        let subId = $(this).attr("subid")
        let tableData = data[`dragB${subId}`]
        if (tableData && subId) initTable($(this), JSON.parse(tableData))
      }
    }
  })

  // 新增需求 通过ID给表格内组件设值
  for (let key in data) {
    let elm = $("#" + key)
    if (!elm.parent().is("td")) continue
    if (elm.is("input")) {
      elm.val(data[key]).trigger("change")
    }
    if (elm.is("select")) {
      elm.val(data[key]).trigger("change")
      elm.attr("filter_value", data[key])
      // let firstVal = elm.find("option:first").val()
      // let defVal = elm.val()
      // elm.empty()
      // if (isEmpty(firstVal)) $("<option>").appendTo(elm)
      // let opts = JSON.parse(data[key])
      // let vals = JSON.parse(data[key + "_INDEX"])
      // for (let i = 0; i < opts.length; i++) {
      //   $("<option>", {text: opts[i], value: vals[i]}).appendTo(elm)
      //   if (vals[i] == defVal) elm.val(value)
      // }
    }
  }
}
function getFormData() {
  let form = $("#form1").clone()
  let table = form.find("table").remove()
  let formData = {}
  form.find(":disabled").each(function() {
    $(this).removeAttr("disabled")
  })
  form.serializeArray().forEach(item => {
    let elm = $(`#${item.name}`)
    let regex = elm.attr("regex")
    let value = elm.val()
    if (regex && regex.indexOf("#,#") != -1) value = value.replaceAll(",", "")
    if (regex && regex.indexOf("$1-$2") != -1) value = value.replaceAll("-", "")
    formData[item.name] = value
  })
  $("#form1 input[type='checkbox']").each(function() {
    let name = $(this).attr("name")
    let uncheck = $(this).attr("_uncheck") || 0
    let checked = $(this).attr("_checked") || 1
    let val = $(this).is(":checked") ? checked : uncheck
    formData[name] = val
    let relData = $(this).attr("reldata")
    let list = relData ? relData.substr(9).split(";") : []
    for (let item of list) {
      if (item.split(":")[0] == val) {
        formData[name] = item.split(":")[1]
        break
      }
    }
  })
  $("#form1 div.radios").each(function() {
    let id = $(this).attr("id")
    formData[id] = $(`input[name="${id}"]:checked`).val()
  })
  $("#form1 div.calendar").each(function() {
    let list = []
    $(this).find("input[_holiday]").each(function() {
      list.push({
        "_weekday": $(this).attr("_weekday"),
        "_year": $(this).attr("_year"),
        "_month": $(this).attr("_month"),
        "_day": $(this).attr("_day"),
        "_date": $(this).attr("_date"),
        "_holiday": $(this).attr("_holiday"),
      })
    })
    formData["calendardayentitylist"] = list
    let freefld29 = $(this).attr("freefld29")
    if (freefld29 && formData[freefld29]) formData["year"] = formData[freefld29]
  })
  table.each(function() {
    if (table.is(".table-static")) {
      let dataMap = new Map()
      $(this).find("tbody tr:not(.tempTr)").each(function() {
        let gridOpFlag = $(this).attr("gridOpFlag") || 2
        if (gridOpFlag == -1) return true
        let _class = $(this).attr("class")
        let data = dataMap.get(_class) || {gridOpFlag}
        $(this).find("select").each(function() {
          let name = $(this).attr("name")
          let value = $(this).attr("value")
          data[name] = value
        })
        $(this).find("input, textarea").each(function() {
          let name = $(this).attr("name")
          let value = $(this).val()
          let regex = $(this).attr("regex") 
          if (regex && regex.indexOf("#,#") != -1) value = value.replaceAll(",", "")
          if (regex && regex.indexOf("$1-$2") != -1) value = value.replaceAll("-", "")
          data[name] = value
        })
        dataMap.set(_class, data) 
      })
      let list = []
      for (let data of dataMap.values()) list.push(data)
      formData["grid" + $(this).attr("subid")] = list
      // if ($(this).attr("tablesinglemulti") == 1) {
        
      // } else {
      //   for (let data of dataMap.values()) {
      //     for (let key in data) {
      //       formData[key] = data[key]
      //     }
      //   }
      // }
    } else {
      let list = []
      let thead = $(this).find("thead")
      $(this).find("tbody tr").each(function() {
        let gridOpFlag = $(this).attr("gridOpFlag")
        if (gridOpFlag != -1) {
          let i = 0
          let item = { gridOpFlag, rowindex: $(this).index() + 1 }
          $(this).find("td").each(function() {
            let th = thead.find("tr th").eq(i)
            let kind = th.attr("kind")
            let itemId = th.attr("itemId")
            if (itemId) {
              let value = null
              if (kind == 2) value = $("#" + $(this).find("select").attr("id")).val()
              if (kind == 4) value = $(this).find("input").is(":checked") ? 1 : 0
              if ([5, 7, 9, 14, 17, 18, 19].includes(parseInt(kind))) {
                let input = $(this).find("input")
                let regex = input.attr("regex")
                value = input.val()
                if (regex && regex.indexOf("#,#") != -1) value = value.replaceAll(",", "")
                if (regex && regex.indexOf("$1-$2") != -1) value = value.replaceAll("-", "")
              }
              if (kind == 22) value = $(this).find("input:hidden").val()
              item[itemId] = value
            }
            i++
          })
          list.push(item)
        }
      })
      formData["grid" + $(this).attr("subid")] = list
    }
  })
  return formData
}
function getSession(id) {
  return null
}
function getParam(name) {
  let r = window.location.search.substr(1).match(new RegExp("(^|&)d=([^&]*)(&|$)"))
  let d = decodeURIComponent(r && r[2] ? window.atob(r[2]) : "")
  r = d.match(new RegExp("(^|&)" + name + "=([^&]*)(&|$)"))
  return r && r[2] ? r[2] : null
}
function getUrlSuffix() {
  return window.location.href.indexOf(".html") != -1 ? ".html" : ""
}
function isSearchPage(url) {
  let r = url || window.location.href
  let i = getUrlSuffix() ? -6 : -1
  return r.split("?")[0].substr(i, 1) == "s"
}
function formatNumber() {
  $("input[type='text'][regex='###,###,##0']").each(function() {
    let value = $(this).val().replaceAll(",", "")
    if (!isEmpty(value)) {
      value = parseInt(value).toString()
      value = value.replace(/(?<=\d)(?=(?:\d{3})+(?!\d))/g, ",")
    }
    $(this).val(value)
  })
}
function changeWeek(week, id) {
  let checked = $("#" + id).is(":checked")
   $("input[_weekday='" + week + "']").each(function() {
    $(this).attr("_holiday", checked ? 1 : 0).prop("checked", checked)
  })
}
function changeLanguage() {
  let i18n = lang == "jp" ? i18n_jp : i18n_zh
  $("[i18n]").each(function() { $(this).html(i18n[$(this).attr("i18n")]) })
  if (getUrlSuffix()) return
  $.i18n.properties({
    name: "saasforce",
    path: "../static/i18n/",
    mode: "map",
    language: lang,
    async: true,
    callback: function() {
      console.log($.i18n.prop("checkuserjpn.lbl_00097"))
    }
  })
}
function buildPrevPage() {
  let prev = $("<div>", {class: "prevPageItem"}).appendTo(".content-wrapper")
  $("<i>", {class: "bx bx-chevron-left"}).appendTo(prev)
  prev.on("click", function() {
    let index = sessionStorage.getItem("index")
    index = parseInt(index) - 1
    let list = JSON.parse(sessionStorage.getItem(mainId))
    sessionStorage.setItem("index", index)
    let kvs = []
    for (key in list[index]) kvs.push({key, value: list[index][key]})
    window.location.href = "?d=" + window.btoa(encodeURIComponent("kvs=" + JSON.stringify(kvs) + "&mode=1&actflg=2"))
  })
}
function buildNextPage(index) {
  let next = $("<div>", {class: "nextPageItem"}).appendTo(".content-wrapper")
  $("<i>", {class: "bx bx-chevron-right"}).appendTo(next)
  next.on("click", function() {
    let index = sessionStorage.getItem("index")
    index = parseInt(index) + 1
    let list = JSON.parse(sessionStorage.getItem(mainId))
    sessionStorage.setItem("index", index)
    let kvs = []
    for (key in list[index]) kvs.push({key, value: list[index][key]})
    window.location.href = "?d=" + window.btoa(encodeURIComponent("kvs=" + JSON.stringify(kvs) + "&mode=1&actflg=2"))
  })
}
function optimizeUI() {

  $(".floatDiv").each(function() {
    let row = $("<div>", {class: "row"}).appendTo($("#form1"))
    let container = $(this).parent().appendTo(row)
    container.addClass("floatContainer")
    let maxWidth = container.data().width
    if (maxWidth && maxWidth != 0) container.css("max-width", maxWidth)

    let elms = []
    for (let id of $(this).attr("reldata").split(",")) {
      elms.push($("#" + id.toLowerCase().replaceAll("_", "")).closest("[id^='dragB']"))
    }
    elms = elms.sort(function(a, b) {return $(a).data().top - $(b).data().top})
    let top = elms.length && elms[0].data().top
    let item = $("<div>", {class: "row"}).appendTo($(this))
    for (let elm of elms) {
      if ($(elm).data().top != top) {
        top = $(elm).data().top
        item = item.clone().empty().appendTo($(this))
      }
      $(elm).appendTo(item)
    }
    $(this).find(".row").each(function() {
      let col = parseInt(12 / $(this).children().length)
      $(this).children().addClass("col-" + col)
    })

    // freefld29 浮动位置：1左上，2左中，3左下，4右上，5右中，6右下
    let freefld29 = parseInt($(this).attr("freefld29"))
    if (freefld29 == 1) container.css({"left": "5px", "top": "100px"})
    if (freefld29 == 2) container.css({"left": "5px", "top": "40vh"})
    if (freefld29 == 3) container.css({"left": "5px", "bottom": "20px"})
    if (freefld29 == 4) container.css({"right": "5px", "top": "100px"})
    if (freefld29 == 5) container.css({"right": "5px", "top": "40vh"})
    if (freefld29 == 6) container.css({"right": "5px", "bottom": "20px"})

    let div = $(this)
    let icon = $("<i>", {class: "icon"}).appendTo(container)
    if (freefld29 < 4) {
      icon.addClass("bx bx-chevron-left")
      icon.css("right", "10px")
      icon.on("click", function() {
        if (div.is(":hidden")) {
          icon.removeClass("bx-chevron-right")
          icon.addClass("bx-chevron-left")
          div.show()
        } else {
          icon.removeClass("bx-chevron-left")
          icon.addClass("bx-chevron-right")
          div.hide()
        }
      })
    } else {
      icon.addClass("bx bx-chevron-right")
      icon.css("left", "10px")
      icon.on("click", function() {
        if (div.is(":hidden")) {
          icon.removeClass("bx-chevron-left")
          icon.addClass("bx-chevron-right")
          div.show()
        } else {
          icon.removeClass("bx-chevron-right")
          icon.addClass("bx-chevron-left")
          div.hide()
        }
      })
    }
  })

  $(".column").each(function() {
    if ($(this).children().length == 0) $(this).hide()
  })

  for (let row of $("#form1").children(".row")) {

    if (isSearchPage()) continue
    if ($(row).find("table").length) continue
    if ($(row).find(".column").length) continue
    if ($(row).find(".calendar").length) continue
    if ($(row).find(".floatDiv").length) continue
    if ($(window).width() < pageWidth[0]) continue

    const filterElm = (row) => {
      let elms = $(row).children("div").filter(function() { return $(this).css("display") != "none" })
      let boxNum = 0
      let btnNum = 0
      let linkNum = 0
      let labelNum = 0
      for (let elm of elms) {
        if ($(elm).find("input").length) boxNum++
        if ($(elm).find("select").length) boxNum++
        if ($(elm).find("textarea").length) boxNum++
        if ($(elm).find("button").length) btnNum++
        if ($(elm).find("div.label").length) labelNum++
        if ($(elm).find("div.textLink").length) linkNum++
      }
      return {elms, boxNum, btnNum, labelNum, linkNum}
    }

    let {elms, boxNum, btnNum, labelNum, linkNum} = filterElm(row)
    
    if (elms.length == 0) continue

    $(row).css("max-width", pageWidth[0])

    if (linkNum == elms.length) {
      let elmNum = elms.length
      let prev = $(row).prev(".row")
      while (true) {
        let len = prev.find(".textLink").length
        if (len == 0) break
        if (len > elmNum) elmNum = len
        prev = prev.prev(".row")
      }

      if (elmNum > elms.length) {
        let prev = $(row).prev(".row")
        while (true) {
          let len = prev.find(".textLink").length
          if (len == elmNum) {
            let jump = 0
            let children = filterElm(prev).elms
            for (let x = 0; x < elms.length; x++) {
              for (let y = x + jump; y < children.length; y++) {
                let elm = $(elms[x])
                let child = $(children[y])
                if (elm.data().left == child.data().left) {
                  break
                } else {
                  let div = $("<div>")
                  div.attr("data-top", child.data().top)
                  div.attr("data-left", child.data().left)
                  div.attr("data-width", child.data().width)
                  elm.before(div)
                  row = elm.parents(".row")
                  jump++
                }
              }
            }
            elms = filterElm(row).elms
            break
          }
          prev = prev.prev(".row")
        }
      }

      $(elms).css({ width: pageWidth[0] / elms.length })
      continue
    }

    if (labelNum == elms.length) {
      if (labelNum == 1) {
        $(elms).parent().addClass("col-12")
        $(elms).children(".label").addClass("alert alert-dark")
      } else {
        $(elms).css("margin", "10px 0")
        $(elms).css({ width: pageWidth[0] / elms.length })
      }
      continue
    }

    let round = 0
    for (let elm of elms) {
      let width = parseInt($(elm).data().width)
      let labelWidth = parseInt($(elm).data().labelwidth)
      round += Math.round((width + labelWidth) / pageWidth[1] * 12)
    }

    let colNum = 0
    for (let elm of elms) {
      if ($(elm).find("button").length > 0) continue
      let width = parseInt($(elm).data().width)
      let labelWidth = parseInt($(elm).data().labelwidth)
      let col = (width + labelWidth) / pageWidth[1] * 12
      // col = Math.max(Math.ceil(col), 1)  // 向上取整 比例计算
      // col = Math.max(Math.floor(col), 1) // 向下取整 比例计算
      col = Math.max(Math.round(col), 1) // 四舍五入 比例计算
      col = col < 3 ? 2 : col < 4 ? 3 : col < 5 ? 4 : col < 7 ? 6 : col < 9 ? 8 : 12
      $(elm).addClass("col-" + col)
      colNum += col

      // 合并组件
      let label = $(elm).find(".form-label").filter(function() { return $(this).css("display") != "none" })
      if (label.length) {
        let text = label.text().replace(/\s|\*/g, "")
        if (text.length === 1 && /[\uFF00-\uFFEF]/.test(text)) {
          let prev = $(elm).prev()
          if (prev.length) {
            let n1 = parseInt(prev.attr("class").match(/col-(\d+)/)[1])
            let n2 = parseInt($(elm).attr("class").match(/col-(\d+)/)[1])
            $(label).css("width", "40px")
            prev.append($(elm).children())
            prev.removeClass("col-" + n1).addClass("col-" + (n1 + n2))
            $(elm).remove()
          }
        }
      }
    }

    // 分配剩余空间
    if (colNum < 12) {
      let num = 12 - colNum
      let {elms, boxNum} = filterElm(row)

      elms.filter(".col-2").each(function() {
        let label = $(this).find(".form-label")
        let check = $(this).find(".form-check")
        if (check.length == 0 && $(label).css("display") == "block") {
          if (num > 0) num--
          $(this).removeClass("col-2")
          $(this).addClass("col-3")
        }
      })

      elms.filter(".col-4").each(function() {
        let label = $(this).find(".form-label")
        if (label.length == 2 && $(label[0]).css("display") == "block") {
          if (num > 2) num = num - 2
          $(this).removeClass("col-4")
          $(this).addClass("col-6")
        }
      })
    }

    // 压缩溢出空间
    if (colNum > 12) {
      let num = 12 - colNum
      while (num < 0) {
        let {elms} = filterElm(row)
        let maxElm = $(elms[0])
        for (let i = 1; i < elms.length; i++) {
          let elm = $(elms[i])
          let a = parseInt(elm.attr("class").match(/col-(\d+)/)[1])
          let b = parseInt(maxElm.attr("class").match(/col-(\d+)/)[1])
          if (a > b) maxElm = elm
        }
        let col = maxElm.attr("class").match(/col-(\d+)/)[1]
        maxElm.removeClass("col-" + col)
        maxElm.addClass("col-" + (col - 1))
        num++
      }
    }

    if (colNum >= 12 && btnNum > 0) {
      let list = $(elms).filter(function() {
        return $(this).find("button").length == 0
      })
      for (let item of list) {
        let cla = $(item).attr("class").match(/col-(\d+)/)
        let col = list.length == 1 ? 3 : list.length == 2 ? 2 : 1
        $(item).removeClass(cla[0]).addClass("col-" + (cla[1] - col))
      }
    }

    // if (boxNum > 0 && btnNum > 0) {
    //   let leftNum = 0
    //   let widthNum = 0
    //   for (let i = 0; i < elms.length; i++) {
    //     let lastLeft = $(elms[i == 0 ? i : i-1]).data().left
    //     let lastWidth = i == 0 ? 0 : $(elms[i-1]).data().width
    //     leftNum += $(elms[i]).data().left - lastLeft - lastWidth
    //     widthNum += $(elms[i]).data().width
    //   }
    //   if ((leftNum + widthNum) / pageWidth[1] < 0.85) {
    //     let elm = $(elms[elms.length-1])
    //     let alignRight = (parseInt(elm.data().width) + parseInt(elm.data().left) + 150) > pageWidth[1]
    //     while (alignRight && elm.find("button").length > 0) elm = elm.prev()
    //     if (elm && elm.find("button").length == 0) {
    //       elm.after($("<div>", {class: "col-1", style: "flex-grow: 1;"}))
    //     }
    //   }
    // }

    // 处理特殊的 label 组件 用于连接两个 textbox
    if (labelNum) {
      $(elms).children(".label").each(function() {
        let parent = $(this).parent()
        // if (parent.prev().length == 0) parent.css({"flex-grow": 1})
        // if (parent.next().length && parent.next().data().labelwidth == 0) parent.css({"width": "auto"})
        let num = 0
        let next = parent.next()
        while (next.length) {
          if (next.find("input[type='checkbox']").length) {
            let width = parseInt(next.data().width)
            let labelwidth = next.find(".form-label").text().trim().length * 15 + 35
            let col = Math.max(1, parseInt((width + labelwidth) / pageWidth[1] * 12))
            let cla = next.attr("class").match(/col-(\d+)/)
            next.removeClass(cla[0]).addClass("col-" + col)
            next.find(".form-label").css("width", labelwidth)
            num += cla[1] - col
          }
          next = next.next()
        }
        if (num) {
          let list = parent.siblings().filter(function() {
            return $(this).find("[type='checkbox']").length == 0
          })
          for (let item of list) {
            let cla = $(item).attr("class").match(/col-(\d+)/)
            $(item).removeClass(cla[0]).addClass("col-" + (parseInt(num / list.length) + parseInt(cla[1])))
          }
        }
      })
    }
  }

  let staticTableWidth = 0
  $(".table-static th").each(function() {
    staticTableWidth += parseInt($(this).data().width)
  })
  $(".table-static th").each(function() {
    let width = parseInt($(this).data().width)
    width = (width / staticTableWidth) * 100
    $(this).css("width", width + "%")
  })

  $("body").fadeIn("slow")
}
function formatDate(date) {
  let year = date.getFullYear()
  let month = date.getMonth() + 1
  if (month < 10) month = "0" + month
  let day = date.getDate()
  if (day < 10) day = "0" + day
  return year + '-' + month + "-" + day
}

$(function() {

  $("#form1").submit(function(e) {
    e.preventDefault()
  })

  $("#changeTheme").on("click",function() {
    let theme = localStorage.getItem("theme") || "light"
    localStorage.setItem("theme", theme == "light" ? "drak" : "light")
    loadTheme()
  })
  $("#logout").on("click", function() {
    window.location.href = getUrlSuffix() ? "login.html" : "logout"
  })
  $("#changePassword").on("click", function() {
    window.location.href = "password" + getUrlSuffix()
  })
  $("#btn_return").on("click", function(e) {
    e.preventDefault()
    window.history.back()
  })
  $("body").keydown(function(e) {
    if (e.keyCode === 13 && !$(e.target).is("textarea")) {
      e.preventDefault()
      if (enterToTab) {
        let elms = $(":input:visible:not(button)")
        elms.eq(elms.index($(":focus"))+1).focus()
      }
    }
  })

  $("body").on("click", "input[type='checkbox']", function() {
    $(this).val($(this).is(":checked") ? 1 : 0)
  })

  $("body").on("focus", "input", function() {
    let val = $(this).val()
    let regex = $(this).attr("regex")
    if (isEmpty(val) || isEmpty(regex)) return
    if (regex != "###,###,##0" && regex != "#,##0") return
    $(this).val(val.replaceAll(",", ""))
  })

  $("body").on("blur", "input", function() {
    let val = $(this).val()
    let regex = $(this).attr("regex")
    if (isEmpty(val) || isEmpty(regex)) return
    if (regex != "###,###,##0" && regex != "#,##0") return
    val = val.replaceAll(",", "")
    if (!isEmpty(val)) {
      val = parseInt(val).toString()
      val = val.replace(/(?<=\d)(?=(?:\d{3})+(?!\d))/g, ",")
    }
    $(this).val(val)
  })

  $("body").on("change", "input, textarea, select", function() {
    $(this).attr("value", $(this).val())
    if (isSearchPage() && $(this).val() == "[自動採番]") $(this).val("")
    if ($(this).is(".ErrStyle")) $(this).removeClass("ErrStyle")
    if ($(this).attr("regex") == "yyyy/MM/dd") {
      let value = $(this).val()
      if (value && !Number.isNaN(new Date(value).valueOf())) {
        let date = formatDate(new Date(value))
        $(this).val(date.replaceAll("-", "/"))
      }
    }
    if ($(this).attr("regex") == "yyyy/MM") {
      let value = $(this).val()
      if (value && !Number.isNaN(new Date(value).valueOf())) {
        let date = new Date(value)
        let year = date.getFullYear()
        let month = date.getMonth() + 1
        if (month < 10) month = "0" + month
        $(this).val(year + "/" + month)
      }
    }
    if ($(this).attr("regex") == "#,##0") {
      let value = $(this).val().trim().replaceAll(",", "")
      if (!isEmpty(value)) {
        value = parseInt(value).toString()
        value = value.replace(/(?<=\d)(?=(?:\d{3})+(?!\d))/g, ",")
      }
      $(this).val(value)
    }
    if ($(this).attr("regex") == "###,###,##0") {
      let value = $(this).val().trim().replaceAll(",", "")
      if (!isEmpty(value)) {
        value = parseInt(value).toString()
        value = value.replace(/(?<=\d)(?=(?:\d{3})+(?!\d))/g, ",")
      }
      $(this).val(value)
    }
    if ($(this).attr("type") == "hidden") {
      let elm = $("#o" + $(this).attr("id"))
      if (elm.is("img")) {
        let url = apiUrl + "/download/" + $(this).val()
        if (isEmpty($(this).val())) {
          url = "../static/img/nofile.gif"
          elm.siblings(".bx-trash").hide()
          elm.siblings(".bx-search-alt").hide()
        } else {
          elm.siblings(".bx-trash").show()
          elm.siblings(".bx-search-alt").show()
        }
        elm.attr("src", url)
        elm.siblings(".bx-search-alt").on("click", function() {
          $(".preview").remove()
          let div = $("<div>", {class: "preview"}).appendTo("body")
          let src = elm.attr("src")
          let img = $("<img>", {src}).appendTo(div)
          let icon = $("<i>", {class: "bx bx-x"}).appendTo(div)
          icon.on("click", function() { div.fadeOut() })
          div.on("click", function() { div.fadeOut() })
          div.fadeIn()
        })
        if (elm.attr("readonly")) {
          elm.siblings(".bx-trash").css("opacity", 0)
          elm.siblings(".bx-search-alt").css("margin-top", "15px")
          elm.siblings(".bx-search-alt").css("z-index", "999")
        } else {
          elm.siblings(".bx-trash").on("click", function() {
            elm.val("")
            elm.attr("src", "../static/img/nofile.gif")
            elm.siblings(".bx-trash").hide()
            elm.siblings(".bx-search-alt").hide()
          })
        }
      }
    }
    if ($(this).is("select")) $(this).attr("filter_value", $(this).val())

    let value = $(this).val()
    let regexkind = $(this).attr("regexkind")
    if (regexkind && value) {
      if (regexkind == 1) {
        value = value.replaceAll(",", "")
        if (!isEmpty(value)) {
          value = parseInt(value).toString()
          value = value.replace(/(?<=\d)(?=(?:\d{3})+(?!\d))/g, ",")
        }
      }
      if (regexkind == 2 || regexkind == 3) {
        value = lang == "jp" ? value.replaceAll("-", "/") : value.replaceAll("/", "-")
      }
      if (regexkind == 4) {
        // 12:00:00 => 12:00
        if (value.length == 8) value = value.substring(0, value.length-3)
      }
      if (regexkind == 6) {
        let format = $(this).attr("regex")
        if (format == "#,##0") {
          value = value.replaceAll(",", "")
          if (!isEmpty(value)) {
            value = parseInt(value).toString()
            value = value.replace(/(?<=\d)(?=(?:\d{3})+(?!\d))/g, ",")
          }
        } else {
          format = format.replaceAll("\\d", "\d")
          format = format.replace('"^', '/')
          format = format.replace('$"', '/')
          value = eval(`value.replace${format}`)
        }
      }
      $(this).val(value)
    }
  })

  $("#uploadFile").on("click", function(e) {
    e.preventDefault()
    let fileInput = $("<input>", { type: "file" })
    let itemId = $(this).attr("itemid")
    fileInput.on("change", function() {
      let formData = new FormData()
      formData.append(`${itemId}importFile`, fileInput[0].files[0])
      formData.append("delExistData", $("#delExistData").is(":checked") ? 1 : 0)
      formData.append("updateExistData", $("#updateExistData").is(":checked") ? 1 : 0)
      let data = getFormData()
      for (let key in data) {
        if (typeof data[key] == "object") {
          let i = 0
          for (let item of data[key]) {
            for (let objKey in item) {
              formData.append(key + "[" + i +  "]." + objKey, item[objKey])
            }
            i++
          }
        } else {
            formData.append(key, data[key])
        }
      }
      let url = apiUrl + "/" + mainId + itemId + "Import.do"
      ajax(url, formData, "uploadFileAfter(data)", false)
    })
    fileInput.click()
  })

  // todo 添加宽度变化监听
  $("#form1 table").each(function() {
    let width = 110
    $(this).find("th").each(function() {
      if ($(this).css("display") != "none") width += parseInt($(this).css("min-width"))
    })
    if (width > $(window).width()) $(this).find("i.bx-chevron-down").show()
  })

  $(".dropdown-item.show").on("click", function() {
    $(this).parents("th").siblings("[hide='1']").css("display", "table-cell")
    $(this).parents("th").siblings("[hide='1']").removeAttr("hide")
  })
  
  $(".dropdown-item.hide").on("click", function() {
    $(this).parents("th").attr("hide", "1")
    $(this).parents("th").css("display", "none")
  })

  $(".dropdown-item.lock").on("click", function() {
    let index = $(this).parents("th").index() + 1
    $(this).parents("table").find("tr").each(function() {
      let left = 0
      $(this).find("th:lt(" + index + "), td:lt(" + index + ")").each(function() {
        $(this).css({"position": "sticky", "left": left + "px"})
        left += parseFloat($(this).css("width"))
        if ($(this).is("th")) $(this).css("background", "#D6EAF8")
      })
    })
    $(".dropdown-item.lock").hide()
    $(".dropdown-item.unLock").show()
  })

  $(".dropdown-item.unLock").on("click", function() {
    $(this).parents("table").find("th, td").each(function() {
      $(this).css({"position": "unset"})
      if ($(this).is("th")) $(this).css("background", "none")
    })
    $(".dropdown-item.lock").show()
    $(".dropdown-item.unLock").hide()
  })

  $(".eyeIcon").on("click", function() {
    let input = $(this).parent().find("input")
    if (input.attr("type") == "password") {
      input.attr("type", "text")
      $(this).attr("src", "../static/img/hide-regular-24.png")
    } else {
      input.attr("type", "password")
      $(this).attr("src", "../static/img/show-regular-24.png")
    }
  })
})

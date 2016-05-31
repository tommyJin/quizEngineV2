/**
 * Created by tommy on 2016/5/31.
 */
var div = "#questiontype";
var blank_html = '<div class="am-g am-margin-top">' +
    '<div class="am-u-sm-4 am-u-md-2 am-text-right">Add blank</div>' +
    '<div class="am-u-sm-8 am-u-md-4 am-u-end col-end">' +
    '<input type="button" id="true" class="am-btn am-btn-success" value="Add one blank" onclick="addBlank()" />' +
    '</div></div>';

function initType() {
    var type = $("#type").find("option:selected").text();
    //alert(type);
    $(div).empty();
    if (type == "True Or False") {
        trueFalse();
    } else if (type == "Calculate Numeric") {
        $(div).append(blank_html);
        calculateNumeric();
    } else if (type == "MultipleChoice") {

    }
}

function fillBlank() {
    var id = $("#id").val();
    var qc_content = $("#qc_content").val();
    var answer = $("#answer").val();
    $("#answer").val(answer);
}

function calculateNumeric() {
    var id = $("#id").val();
    var answer = $("#answer").val();
    if (id != null && id.length != 0 && answer != null && answer.length != 0) {
        var a = $.parseJSON(answer);
        for (var i = 0; i < a.length; i++) {
            var tmp_id = a[i].id;
            var tmp_val = a[i].val;
            if (tmp_id != null && tmp_id.length != 0 && tmp_val != null && tmp_val.length != 0) {
                addBlankContent(tmp_id, tmp_val);
            }
        }
    }
    var answer = $("#answer").val();
    $("#answer").val(answer);
}

function fillBlanks() {

}

function trueFalse() {
    var id = $("#id").val();
    var qc_content = $("#qc_content").val();
    var true_content = "";
    var false_content = "";
    var answer = $("#answer").val();
    if (id != null && id.length != 0 && qc_content != null && qc_content.length != 0) {
        var qc = $.parseJSON(qc_content);
        true_content = qc.true;
        false_content = qc.false;
    }
    var content =
            '<div class="am-g am-margin-top">' +
            '<div class="am-u-sm-4 am-u-md-2 am-text-right">True</div>' +
            '<div class="am-u-sm-8 am-u-md-4 am-u-end col-end">' +
            '<input type="text" id="true" class="am-form-field" value="" />' +
            '</div></div>' +
            '<div class="am-g am-margin-top">' +
            '<div class="am-u-sm-4 am-u-md-2 am-text-right">False</div>' +
            '<div class="am-u-sm-8 am-u-md-4 am-u-end col-end">' +
            '<input type="text" id="false" class="am-form-field" value="" />' +
            '</div></div>' +
            '<div class="am-g am-margin-top">' +
            '<div class="am-u-sm-4 am-u-md-2 am-text-right">Right Answer</div>' +
            '<div class="am-u-sm-8 am-u-md-10">' +
            '<select  id="tf_answer" name="qc.answer" >' +
            '<option value="true">True</option>' +
            '<option value="false">False</option>' +
            '</select></div></div>'
        ;
    $(div).append(content);
    $("#tf_answer").val(answer);
    $("#true").val(true_content);
    $("#false").val(false_content);
}

function collect() {
    var type = $("#type").find("option:selected").text();
    var answer_str = $("#answer").val() + "";
    $("#answer").val(answer_str);
    if (type == "True Or False") {
        var content = {};
        var true_content = $("#true").val();
        var false_content = $("#false").val();
        content[true] = true_content;
        content[false] = false_content;
        var content_str = JSON.stringify(content);
        $("#qc_content").val(content_str);
    } else if (type == "Calculate Numeric") {
        var content = [];
        var answer = [];
        $(":input.blank_content").each(function () {
            var tmp_a = {};
            var tmp_c = {};
            tmp_c.id = this.id.split("-")[1];
            tmp_a.id = this.id.split("-")[1];
            tmp_a.val = this.value;
            answer.push(tmp_a);
            content.push(tmp_c);
        });

        var content_str = JSON.stringify(content);
        var answer_str = JSON.stringify(answer);
        $("#answer").val(answer_str);
        $("#qc_content").val(content_str);
    } else if (type == "MultipleChoice") {

    }
}

function addBlank() {
    var index = "blank_" + ( Number($("#blankIndex").val()) + 1);
    ke_content.insertHtml('<input type="button" id="' + index + '" value="' + index + '" disabled/>');
    addBlankContent(index, "");
}

function addBlankContent(index, v) {
    var content = '<div class="am-g am-margin-top">' +
        '<div class="am-u-sm-4 am-u-md-2 am-text-right">' + index + '</div>' +
        '<div class="am-u-sm-8 am-u-md-4 am-u-end col-end">' +
        '<input type="text" id="content-' + index + '" class="am-form-field blank_content" value="' + v + '" />' +
        '</div></div>';
    $("#blankIndex").val(index.split("_")[1]);
    $(div).append(content);
}

function deleteBlank(index){

}
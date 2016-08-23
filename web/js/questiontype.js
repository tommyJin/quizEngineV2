/**
 * Created by tommy on 2016/5/31.
 */
var div = "#questiontype";


function initType() {
    var type = $("#type :selected").text();
    //alert(type);
    $(div).empty();
    if (type == "True Or False") {
        trueFalse();
    } else if (type == "Calculate Numeric") {
        $(div).append(add_blank_button_html);
        //calculateNumeric();
        fillBlank();
    } else if (type == "Multiple Choice" || type == "Multiple Answer") {
        $(div).append(add_choice_button_html);
        multipleChoice();
    } else if (type == "Fill in the Blank") {
        if($("#id").val().length<=0){
            $(div).append(add_blank_button_html);
        }
        fillBlank();
    } else if (type == "Fill in Multiple Blanks"){
        $(div).append(add_blank_button_html);
        fillBlank();
    }

}

function fillBlank() {
    var id = $("#id").val();
    var answer = $("#answer").val();
    if (id != null && id.length != 0 && answer != null && answer.length != 0) {
        var a = $.parseJSON(answer);
        for (var i = 0; i < a.length; i++) {
            var tmp_id = a[i].id;
            var tmp_answer = a[i].answer;
            var tmp_feedback = a[i].feedback;
            if (tmp_id != null && tmp_id.length != 0) {
                addBlankContent(tmp_id, tmp_answer, tmp_feedback);
            }
        }
    }
}

function calculateNumeric() {

}

function multipleChoice() {
    var id = $("#id").val();
    var answer = $("#answer").val();
    if (id != null && id.length != 0 && answer != null && answer.length != 0) {
        var a = $.parseJSON(answer);
        var mc_answer = "";
        var num = 0;
        for (var i = 0; i < a.length; i++) {
            var tmp_id = a[i].id;
            var tmp_choice = a[i].choice;
            var tmp_feedback = a[i].feedback;
            var tmp_isRight = a[i].isRight;
            num = a[i].number;
            $("#choice_number").val(num);//set the number of choice
            if (tmp_id != null && tmp_id.length != 0) {
                addMultipleChoiceContent(tmp_id, tmp_choice, tmp_feedback);
            }
            if (tmp_isRight) {
                mc_answer += (mc_answer == "") ? tmp_id : ";" + tmp_id;
                setRightChoice(tmp_id);
            } else {
                cancelRightChoice(tmp_id);
            }
        }
        $("#mc_answer").val(mc_answer);
    }
}

function trueFalse() {
    var id = $("#id").val();
    var answer = $("#answer").val();
    addTrueFalse(answer);
}

function collect() {
    var type = $("#type").find("option:selected").text();
    var answer_str = $("#answer").val() + "";
    $("#answer").val(answer_str);
    if (type == "True Or False") {
        var content = {};
        var answer = {};
        var true_content = $("#true_content").val();
        var false_content = $("#false_content").val();
        var feedback_true = $("#feedback-true").val();
        var feedback_false = $("#feedback-false").val();
        var right = $("#tf_answer").val();
        content.true_content = true_content;
        content.false_content = false_content;
        answer.true_content = true_content;
        answer.false_content = false_content;
        answer.feedback_true = feedback_true;
        answer.feedback_false = feedback_false;
        answer.right = right;
        var content_str = JSON.stringify(content);
        var answer_str = JSON.stringify(answer);
        $("#qc_content").val(content_str);
        $("#answer").val(answer_str);
    } else if (type == "Multiple Choice" || type == "Multiple Answer") {
        var mc_answer = $("#mc_answer").val();
        var num = $("#choice_number").val();
        if(mc_answer.length<1){
            alert("There must be at least 1 right answer!");
            return false;
        }else{
            if(mc_answer.split(";").length>num){
                alert("You have set more than 1 answer!");
                return;
            }else{
                var content = [];
                var answer = [];

                var size = $("#choiceIndex").val();
                for (var i = 1; i <= size; i++) {
                    var tmp_c_id = "#content-choice_" + i;
                    var tmp_f_id = "#feedback-choice_" + i;
                    var tmp_c_div = $(tmp_c_id);
                    var tmp_f_div = $(tmp_f_id);

                    var tmp_a = {};
                    var tmp_c = {};
                    tmp_c.id = tmp_c_id.split("-")[1];
                    tmp_c.choice = tmp_c_div.val();
                    tmp_c.number = num;
                    tmp_a.id = tmp_c_id.split("-")[1];
                    tmp_a.choice = tmp_c_div.val();
                    tmp_a.feedback = tmp_f_div.val();
                    tmp_a.number = num;
                    tmp_a.isRight =  mc_answer.indexOf("choice_"+i) > -1;
                    answer.push(tmp_a);
                    content.push(tmp_c);
                }
                var content_str = JSON.stringify(content);
                var answer_str = JSON.stringify(answer);
                $("#answer").val(answer_str);
                $("#qc_content").val(content_str);
            }
        }
    } else if (type == "Calculate Numeric" || type == "Fill in the Blank" || type == "Fill in Multiple Blanks") {
        var content = [];
        var answer = [];

        var size = $("#blankIndex").val();
        for (var i = 1; i <= size; i++) {
            var tmp_c_id = "#content-blank_" + i;
            var tmp_f_id = "#feedback-blank_" + i;
            var tmp_c_div = $(tmp_c_id);
            var tmp_f_div = $(tmp_f_id);

            var tmp_a = {};
            var tmp_c = {};
            tmp_c.id = tmp_c_id.split("-")[1];
            tmp_a.id = tmp_c_id.split("-")[1];
            tmp_a.answer = tmp_c_div.val();
            tmp_a.feedback = tmp_f_div.val();
            answer.push(tmp_a);
            content.push(tmp_c);
        }

        var content_str = JSON.stringify(content);
        var answer_str = JSON.stringify(answer);
        $("#answer").val(answer_str);
        $("#qc_content").val(content_str);
    }
    return true;
}

function addBlank() {
    var index = "blank_" + ( Number($("#blankIndex").val()) + 1);
    ke_content.insertHtml('<input type="button" id="' + index + '" value="' + index + '" disabled/>');
    addBlankContent(index, "", "");
    if($("#type :selected").text()=="Fill in the Blank"){
        $("#add_blank_button").attr("disabled","disabled");
    }
}

function addBlankContent(index, answer, feedback) {
    var content = '<div class="am-g am-margin-top">' +
        '<div class="am-u-sm-4 am-u-md-2 am-text-right">' + index + '</div>' +
        '<div class="am-u-sm-8 am-u-md-4 am-u-end col-end">' +
        '<input type="text" id="content-' + index + '" class="am-form-field blank_content" value="' + answer + '" />' +
        '</div></div>';
    //content end here

    //add feedback editor
    content += '<div class="am-g am-margin-top-sm"><div class="am-u-sm-2 am-text-right">' + index + ' Feedback</div>' +
        '<div class="am-u-sm-10">' +
        '<textarea id="feedback-' + index + '" class="am-form-field blank_content editor" name="' + index + '" rows="10" placeholder="Input content here" value="' + feedback + '"></textarea>' +
        '</div> </div>';
    $("#blankIndex").val(index.split("_")[1]);
    $(div).append(content);
    addKE(index);//add a new KindEditor
    KE.html('#feedback-' + index, feedback);
}

function addTrueFalse(data) {
    var true_content = "";
    var true_feedback = "";
    var false_content = "";
    var false_feedback = "";
    var right = "true";
    var answer = "";
    if (data.length>0){
        answer =  $.parseJSON(data);
    }
    if (answer.true_content != null && answer.feedback_true != null && answer.false_content != null && answer.feedback_false != null && answer.right != null) {
        true_content = answer.true_content;
        true_feedback = answer.feedback_true;
        false_content = answer.false_content;
        false_feedback = answer.feedback_false;
        right = answer.right;
    }
    var truefalse_html =
            '<div class="am-g am-margin-top">' +
            '<div class="am-u-sm-4 am-u-md-2 am-text-right">True</div>' +
            '<div class="am-u-sm-8 am-u-md-4 am-u-end col-end">' +
            '<input type="text" id="true_content" class="am-form-field" value="' + true_content + '" />' +
            '</div></div>' +

                //KE
            '<div class="am-g am-margin-top-sm"><div class="am-u-sm-2 am-text-right">True Feedback</div>' +
            '<div class="am-u-sm-10">' +
            '<textarea id="feedback-true" class="am-form-field blank_content editor" name="feedback_true" rows="10" placeholder="Input content here" value="' + true_feedback + '"></textarea>' +
            '</div> </div>' +

            '<div class="am-g am-margin-top">' +
            '<div class="am-u-sm-4 am-u-md-2 am-text-right">False</div>' +
            '<div class="am-u-sm-8 am-u-md-4 am-u-end col-end">' +
            '<input type="text" id="false_content" class="am-form-field" value="' + false_content + '" />' +
            '</div></div>' +

                //KE
            '<div class="am-g am-margin-top-sm"><div class="am-u-sm-2 am-text-right">False Feedback</div>' +
            '<div class="am-u-sm-10">' +
            '<textarea id="feedback-false" class="am-form-field blank_content editor" name="feedback_false" rows="10" placeholder="Input content here" value="' + false_feedback + '"></textarea>' +
            '</div> </div>' +

            '<div class="am-g am-margin-top">' +
            '<div class="am-u-sm-4 am-u-md-2 am-text-right">Right Answer</div>' +
            '<div class="am-u-sm-8 am-u-md-10">' +
            '<select  data-am-selected="{btnSize: \'sm\'}"  id="tf_answer" name="qc.answer" >' +
            '<option value="true">True</option>' +
            '<option value="false">False</option>' +
            '</select></div></div>'
        ;
    $(div).append(truefalse_html);
    $("#tf_answer").val(right);
    addKE("feedback_true");//add a new KindEditor
    addKE("feedback_false");//add a new KindEditor
    KE.html('#feedback-true', true_feedback);
    KE.html('#feedback-false', false_feedback);
}

function setRightChoice(index) {
    var answer = $("#mc_answer").val();
    var num = $("#choice_number").val();
    if (answer == "") {
        $("#mc_answer").val(index);
    } else {
        if(num>1){
            $("#mc_answer").val(answer + ";" + index);
        }else{
            alert("You can only set 1 answer!");
            return;
        }
    }
    $("#button-set-" + index).css("display", "none");
    $("#button-cancel-" + index).css("display", "block");
}

function cancelRightChoice(index) {
    var answer = $("#mc_answer").val();
    if (answer.indexOf(index)!=-1) {
        var flag = false;
        if (answer.indexOf(index + ";") != -1) {
            answer = answer.replace(index + ";", "");
            flag = true;
        }
        if (answer.indexOf(";" + index) != -1) {
            answer = answer.replace(";" + index, "");
            flag = true;
        }
        if(!flag){
            answer = "";
        }

        $("#button-set-" + index).css("display", "block");
        $("#button-cancel-" + index).css("display", "none");

        $("#mc_answer").val(answer);
    } else {
        $("#button-set-" + index).css("display", "block");
        $("#button-cancel-" + index).css("display", "none");
    }
}

function addMultipleChoice() {
    var index = "choice_" + ( Number($("#choiceIndex").val()) + 1);
    addMultipleChoiceContent(index, "", "");
}

function addMultipleChoiceContent(index, choice, feedback) {//answer is json object
    var content = '<div class="am-g am-margin-top-sm"><div class="am-u-sm-2 am-text-right">' + index +
        '<button type="button" class="am-btn am-btn-success" style="display:block" id="button-set-' + index + '" onclick="setRightChoice(\'' + index + '\')">Set As Right Answer</button>' +
        '<button type="button" class="am-btn am-btn-danger" style="display:none" id="button-cancel-' + index + '" onclick="cancelRightChoice(\'' + index + '\')">Cancel Right Answer</button>' +
        '</div>' +
        '<div class="am-u-sm-10">' +
        '<textarea id="content-' + index + '" class="am-form-field blank_content editor" name="content-' + index + '" rows="10" placeholder="Input content here" ></textarea>' +
        '</div> </div>';
    //content end here

    //add feedback editor
    content += '<div class="am-g am-margin-top-sm"><div class="am-u-sm-2 am-text-right">' + index + ' Feedback</div>' +
        '<div class="am-u-sm-10">' +
        '<textarea id="feedback-' + index + '" class="am-form-field blank_content editor" name="feedback-' + index + '" rows="10" placeholder="Input content here"></textarea>' +
        '</div> </div>';
    $("#choiceIndex").val(index.split("_")[1]);
    $(div).append(content);
    addKE("content-" + index);//add a new KindEditor
    addKE("feedback-" + index);//add a new KindEditor
    KE.html('#content-' + index, choice);
    KE.html('#feedback-' + index, feedback);
}

function deleteBlank(index) {

}

function addKE(ke_id) {
    KE.ready(function (K) {
        ke_id = K.create('textarea[name="' + ke_id + '"]', {
            resizeType: 1,
            allowPreviewEmoticons: false,
            allowFileManager: true,
            allowUpload: true,
            filterMode: false,
            uploadJson: uploadPath(),
            imageUploadJson: uploadPath(),
            afterBlur: function () {
                this.sync();
            },
            items: [
                'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
                'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
                'insertunorderedlist', '|', 'emoticons', 'image', 'multiimage', 'link', 'code']
        });
    });
}


var add_blank_button_html = '<div class="am-g am-margin-top">' +
    '<div class="am-u-sm-4 am-u-md-2 am-text-right">Add blank</div>' +
    '<div class="am-u-sm-8 am-u-md-4 am-u-end col-end">' +
    '<input type="button" id="add_blank_button" class="am-btn am-btn-success" value="Add one blank" onclick="addBlank()" />' +
    '</div></div>';

var add_choice_button_html = '<div class="am-g am-margin-top">' +
    '<div class="am-u-sm-4 am-u-md-2 am-text-right">Add choice</div>' +
    '<div class="am-u-sm-8 am-u-md-8 am-u-end col-end">' +
    '<input type="button" id="add_choice_button" class="am-btn am-btn-success" value="Add one choice" onclick="addMultipleChoice()" />' +
    '</div></div>' +
    '<div class="am-g am-margin-top">' +
    '<div class="am-u-sm-4 am-u-md-2 am-text-right">Right Answer</div>' +
    '<div class="am-u-sm-8 am-u-md-8 am-u-end col-end">' +
    '<input type="text" class="am-form-field" disabled id="mc_answer"/>' +
    '</div></div>'+

    '<div class="am-g am-margin-top">' +
    '<div class="am-u-sm-4 am-u-md-2 am-text-right">Number Of Answer</div>' +
    '<div class="am-u-sm-8 am-u-md-10">' +
    '<select  data-am-selected="{btnSize: \'sm\'}"  id="choice_number" name="qc.answer" >' +
    '<option value="1">One</option>' +
    '<option value="2">More Than One</option>' +
    '</select></div></div>'
    ;
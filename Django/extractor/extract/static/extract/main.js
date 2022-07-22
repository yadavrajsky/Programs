$(".search_for").change(function(event) {
    let div_element = document.getElementById(this.value);

    if (this.checked) {

        $(div_element).html(
            `<a href="#" onclick="show_len_div(${this.id})" class="btn btn-primary set_length">Set length</a>`
        )
    } else {
        $(div_element).html(
            ''
        )
    }
});

function show_len_div(id_div) {

    let div_element = document.getElementById(id_div.value);

    $(div_element).html(
        `
        <div class="mb-3">
            <div class="mb-3 form-check ml-1">
                <input type="radio" name="${id_div.value}_fixed_or_range" onchange="show_range_div(this)" value="fixed">Fixed Length

            </div>
            <div class="mb-3 form-check ml-1" id="${id_div.value}_fixed_div" hidden>
                <label for="from">Enter Fixed Length :</label>
                <input type="number" name="${id_div.value}_fixed_length" min="1" value="1">  
            </div>      
            <div class="mb-3 form-check ml-1">
                <input type="radio" name="${id_div.value}_fixed_or_range" onchange="show_range_div(this)" class="sel_range" value="range">Range
            </div>
            <div class="mb-3 form-check ml-1" id="${id_div.value}_range_div" hidden>
                <label for="from">From</label>
                <input type="number" name="${id_div.value}_from" min="1" value="1">
                <label for="to">To</label>
                <input type="number" name="${id_div.value}_to" min="1" value="1">
            </div>
        </div>            
                `
    )
}

function show_range_div(radio_range) {

    let range_div_id = `#${radio_range.name}`.split('_fixed_or_range')[0] + '_range_div';
    let fixed_div_id = `#${radio_range.name}`.split('_fixed_or_range')[0] + '_fixed_div';

    if (radio_range.value == 'range') {
        $(range_div_id).removeAttr('hidden');
        $(fixed_div_id).attr('hidden', 'true');
    } else {
        $(range_div_id).attr('hidden', 'true');
        $(fixed_div_id).removeAttr('hidden');


    }


};
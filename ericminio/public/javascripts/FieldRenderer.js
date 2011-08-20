var FieldRenderer = {

    renderField: function(field) {

        var table = $("board");
        for (var line = 0; line < field.lineCount(); line++) {
            var tr = table.insertRow(-1);
            for (var column = 0; column < field.columnCount(); column++) {
                var td = tr.insertCell(column);
                td.id = "cell" + line + column;
                td.width = "50";
                td.align = "center";
                td.innerHTML = "<a href='javascript:game.play(" + line + ", " + column + ")'>click</a>";
            }
        }
    },

    hiddenCellCount: function() {
        var hidden = 0;
        var table = $("board");
        for (var i = 0; i < table.rows.length; i++) {
            for (var j = 0; j < table.rows[i].cells.length; j++) {
                if (table.rows[i].cells[j].innerHTML.indexOf("click") != -1) {
                    hidden ++;
                }
            }
        }
        return hidden;
    },

    updateCell: function(line, column, content) {
        $("cell" + line + column).innerHTML = content;
    },

    contentOf: function(line, column) {
        return $("cell" + line + column).innerHTML;
    }

};
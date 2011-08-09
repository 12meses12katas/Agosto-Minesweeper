


module MineSweeper

  class Game

    def play(input_positions)
      output = ""
      field = 1
      iterator = input_positions.each_line
      loop do
        header = iterator.next.split
        lines,columns = header[0].to_i, header[1].to_i
        break if lines == 0 || columns == 0
        string_board = ""
        lines.times { string_board << iterator.next }
        board = get_board(field,lines,columns, string_board)
        output << "\n" if field > 1
        field += 1
        output << board.to_s
      end
      output
    end

    private
    
    def get_board(field, lines, columns, string_board)
      Board.new field,lines,columns, string_board
    end


  end

  class Board

    attr_reader :field, :lines, :columns
    
    def initialize(field, lines, columns, string_board=nil)
      @lines = lines
      @columns = columns
      @field = field
      @string_board = string_board || default_string_board
    end

    def to_s
      output = "Field ##{@field}:\n"
      output << result_board
      output
    end

    def [](line,column)
      index = index(line,column)
      return @string_board[index] unless index.nil?
    end

    def []=(line,column,value)
      index = index(line,column)
      @string_board[index] = value unless index.nil?
    end

    def index(line,column)
      return nil if line<0 || column < 0 || line >= @lines || column >= @columns
      line * (@columns+1) + column
    end

    private

    def result_board
      @string_board.gsub!(".", "0")
      0.upto(@lines-1) do |line|
        0.upto(@columns-1) do |column|
          cell_update line,column
        end
      end
      @string_board
    end

    def cell_update line,column
      if self[line,column] == "*"
        (line-1).upto(line+1) do |line_add|
          (column-1).upto(column+1) do |column_add|
              cell_increment line_add, column_add
          end
        end
      end
    end

    def cell_increment line, column
      cell = self[line,column]
      self[line,column] = (cell.to_i + 1).to_s unless cell == "*"
    end

    def default_string_board
      output = ""
      @lines.times { output << "." * @columns << "\n" }
      output
    end



  end

end
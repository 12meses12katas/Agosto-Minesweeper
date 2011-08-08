


module MineSweeper

  class Game

    def play(input_positions)
      output = ""
      field = 1
      iterator = input_positions.each_line
      loop do
        header = iterator.next.split
        board = get_board(field, header[0].to_i, header[1].to_i)
        output << board.to_s
        break
      end
      output
    end

    def get_board(field, lines, columns)
      Board.new field,lines,columns
    end


  end

  class Board

    attr_reader :field, :lines, :columns
    
    def initialize(field, lines, columns)
      @lines = lines
      @columns = columns
      @field = field
    end

    def to_s
      output = "Field ##{@field}:\n"
      @lines.times do
        output << "." * @columns
        output << "\n"
      end
      output
    end

  end

end
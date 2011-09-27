class Minesweeper
  attr_accessor :arys

  # Parses the input string
  def initialize(str)
    @arys = []
    str.lines.map(&:strip).each do |line|
      if line =~ /\d \d/
        arys << []
      else
        arys.last << line.split('')
      end
    end
  end

  # Return de field with bombs and numbers
  def numbers
    res = ""
    arys.each_with_index do |field, field_index|
      res << "Field ##{field_index + 1}\n" if field.size > 0
      field.each_with_index do |line, i|
        line.each_with_index { |e, j| res << (e == '*' ? '*' : surrounding_bombs(field, i, j)) }
        res << "\n"
      end
    end
    res
  end

  # Counts the number of bombs surrounding a given position (x,y)
  def surrounding_bombs(field, line_index, column_index)
    count = 0
    (-1..1).each do |delta_line|
      (-1..1).each do |delta_column|
        line_pos = line_index + delta_line
        column_pos = column_index + delta_column
        count += 1  if valid_coords(field, line_pos, column_pos) && field[line_pos][column_pos] == '*'
      end
    end
    count.to_s
  end

  # returns true if a given position (x,y) is within the ranges of the array
  def valid_coords(field, line, column)
    (0..field.size-1) === line && (0..field[line].size-1) === column
  end

end
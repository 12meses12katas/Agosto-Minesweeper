
require 'minesweeper'

module MineSweeper

  describe Game do
    it "creates board with correct size" do
      @subject = Game.new
   #   @subject.should_receive(:get_board).with(2,3)
      @subject.play("2 3\n...\n...\n0 0\n")
    end

  end


  describe Board do
    it "admits any board size board" do
      @subject = Board.new(7,3,4)
      @subject.field.should == 7
      @subject.lines.should == 3
      @subject.columns.should == 4
    end


    it "return the correct empty board" do
      @subject = Board.new(7,4,3)
      @subject.to_s.should == "Field #7:\n...\n...\n...\n...\n"
    end

  end
end

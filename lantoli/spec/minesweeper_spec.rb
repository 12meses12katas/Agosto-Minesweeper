
require 'minesweeper'

module MineSweeper

  describe Game do
    it "creates board with correct size" do
      @subject = Game.new
      @subject.should_receive(:get_board).with(1,2,3)
      @subject.play("2 3\n...\n...\n0 0\n")
    end

    it "allows many boards" do
      @subject = Game.new
      @subject.should_receive(:get_board).with(1,2,3).ordered
      @subject.should_receive(:get_board).with(2,1,1).ordered
      @subject.should_receive(:get_board).with(3,3,2).ordered
      @subject.play("2 3\n...\n...\n1 1\n.\n3 2\n..\n..\n..\n0 0")
    end


  end


  describe Board do
    it "allows any board size board" do
      @subject = Board.new(7,3,4)
      @subject.field.should == 7
      @subject.lines.should == 3
      @subject.columns.should == 4
    end


    it "returns the correct empty board" do
      @subject = Board.new(7,4,3)
      @subject.to_s.should == "Field #7:\n...\n...\n...\n...\n"
    end

  end
end

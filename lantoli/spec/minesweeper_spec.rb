
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

    it "returns the correct board for one mine" do
      @subject = Board.new(1,3,3, "...\n.*.\n...\n")
      @subject.to_s.should == "Field #1:\n111\n1*1\n111\n"
    end

    it "index works fine" do
      @subject = Board.new(1,2,3, "...\n...\n")
      @subject.index(0,0).should == 0
      @subject.index(0,1).should == 1
      @subject.index(0,2).should == 2
      @subject.index(1,0).should == 4
      @subject.index(1,1).should == 5
      @subject.index(1,2).should == 6
      @subject.index(0,3).should be_nil
      @subject.index(3,0).should be_nil
      @subject.index(20,10).should be_nil
    end

    it "[] works fine" do
      @subject = Board.new(1,2,3, "abc\ndef\n")
      @subject[0,0].should == "a"
      @subject[0,1].should == "b"
      @subject[0,2].should == "c"
      @subject[1,0].should == "d"
      @subject[1,1].should == "e"
      @subject[1,2].should == "f"
      @subject[14,13].should be_nil
    end

    it "[]= works fine" do
      @subject = Board.new(1,2,3, "...\...\n")
      @subject[0,0] = "a"
      @subject[0,1] = "b"
      @subject[0,2] = "c"
      @subject[1,0] = "d"
      @subject[1,1] = "e"
      @subject[1,2] = "f"
      @subject[10,20] = "Z"
      @subject[0,0].should == "a"
      @subject[0,1].should == "b"
      @subject[0,2].should == "c"
      @subject[1,0].should == "d"
      @subject[1,1].should == "e"
      @subject[1,2].should == "f"
      @subject[10,20].should be_nil
    end

  end
end

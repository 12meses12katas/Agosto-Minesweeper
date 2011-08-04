import static org.junit.Assert.*;
import org.junit.Test 

class MinesweeperTest {
    
    def game = new Minesweeper()
    
    @Test
    public void field1x1Empty(){
        assert ["0"]== game.play(["."])
    }
    
    @Test
    public void field1x1Mine(){
        assert ["*"]== game.play(["*"])
    }
    
    @Test
    public void field2x2Empty(){
        def field = []
        field << [".", "."]
        field << [".", "."]
        
        def expected = []
        expected << ["0", "0"]
        expected << ["0", "0"]
        
        assert expected == game.play(field)
    }
    
    @Test
    public void field2x2MineUpperLeft(){
        def field = []
        field << ["*", "."]
        field << [".", "."]
        
        def expected = []
        expected << ["*", "1"]
        expected << ["1", "1"]
        
        assert expected == game.play(field)
    }
    
    @Test
    public void field2x2MineUpperRight(){
        def field = []
        field << [".", "*"]
        field << [".", "."]
        
        def expected = []
        expected << ["1", "*"]
        expected << ["1", "1"]
        
        assert expected == game.play(field)
    }
    
    @Test
    public void field2x2MineBottonLeft(){
        def field = []
        field << [".", "."]
        field << ["*", "."]
        
        def expected = []
        expected << ["1", "1"]
        expected << ["*", "1"]
        
        assert expected == game.play(field)
    }
    
    @Test
    public void field2x2MineBottonRight(){
        def field = []
        field << [".", "."]
        field << [".", "*"]
        
        def expected = []
        expected << ["1", "1"]
        expected << ["1", "*"]
        
        assert expected == game.play(field)
    }
    
    @Test
    public void field3x3(){
        def field = [
            [".", ".", "."],
            [".", ".", "."],
            [".", ".", "."]
        ]
        def expected = [
            ["0", "0", "0"],
            ["0", "0", "0"],
            ["0", "0", "0"]
        ]
        assert expected == game.play(field)
    }
    
    @Test
    public void field3x3UpperLeft(){
        def field = [
            ["*", ".", "."],
            [".", ".", "."],
            [".", ".", "."]
        ]
        def expected = [
            ["*", "1", "0"],
            ["1", "1", "0"],
            ["0", "0", "0"]
        ]
        assert expected == game.play(field)
    }
    
    @Test
    public void field3x3UpperRight(){
        def field = [
            [".", ".", "*"],
            [".", ".", "."],
            [".", ".", "."]
        ]
        def expected = [
            ["0", "1", "*"],
            ["0", "1", "1"],
            ["0", "0", "0"]
        ]
        assert expected == game.play(field)
    }
    
    @Test
    public void field3x3MidMid(){
        def field = [
            [".", ".", "."],
            [".", "*", "."],
            [".", ".", "."]
        ]
        def expected = [
            ["1", "1", "1"],
            ["1", "*", "1"],
            ["1", "1", "1"]
        ]
        assert expected == game.play(field)
    }
    
    @Test
    public void field3x3BottonLeft(){
        def field = [
            [".", ".", "."],
            [".", ".", "."],
            ["*", ".", "."]
        ]
        def expected = [
            ["0", "0", "0"],
            ["1", "1", "0"],
            ["*", "1", "0"]
        ]
        assert expected == game.play(field)
    }
    
    @Test
    public void field3x3BottonRight(){
        def field = [
            [".", ".", "."],
            [".", ".", "."],
            [".", ".", "*"]
        ]
        def expected = [
            ["0", "0", "0"],
            ["0", "1", "1"],
            ["0", "1", "*"]
        ]
        assert expected == game.play(field)
    }
    
    @Test
    public void field3x3TwoMines(){
        def field = [
            ["*", ".", "."],
            [".", ".", "."],
            [".", ".", "*"]
        ]
        def expected = [
            ["*", "1", "0"],
            ["1", "2", "1"],
            ["0", "1", "*"]
        ]
        assert expected == game.play(field)
    }
    
    @Test
    public void field3x3ThreeMines(){
        def field = [
            ["*", "*", "*"],
            [".", ".", "."],
            [".", ".", "."]
        ]
        def expected = [
            ["*", "*", "*"],
            ["2", "3", "2"],
            ["0", "0", "0"]
        ]
        assert expected == game.play(field)
    }
    
    @Test
    public void field3x3AllButOne(){
        def field = [
            ["*", "*", "*"],
            ["*", ".", "*"],
            ["*", "*", "*"]
        ]
        def expected = [
            ["*", "*", "*"],
            ["*", "8", "*"],
            ["*", "*", "*"]
        ]
        assert expected == game.play(field)
    }
    
    @Test
    public void acceptanceTestOne(){
        def field = [
            ["*", ".", ".", "."],
            [".", ".", ".", "."],
            [".", "*", ".", "."],
            [".", ".", ".", "."]
        ]
        def expected = [
            ["*", "1", "0", "0"],
            ["2", "2", "1", "0"],
            ["1", "*", "1", "0"],
            ["1", "1", "1", "0"]
        ]
        assert expected == game.play(field)
    }
    
    @Test
    public void acceptanceTestTwo(){
        def field = []
        field << ["*", "*", ".", ".", "."]
        field << [".", ".", ".", ".", "."]
        field << [".", "*", ".", ".", "."]
        
        def expected = []
        expected << ["*", "*", "1", "0", "0"]
        expected << ["3", "3", "2", "0", "0"]
        expected << ["1", "*", "1", "0", "0"]
        
        assert expected == game.play(field)
    }
}

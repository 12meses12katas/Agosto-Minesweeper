<?php
require_once dirname(__FILE__) . '/../Minesweeper.php';

class MinesweeperTest extends PHPUnit_Framework_TestCase
{
    private $game;
    public function setUp()
    {
        $this->game = new Minesweeper();
        $this->game->load("4 4\n*...\n....\n.*..\n....\n3 5\n**...\n.....\n.*...\n0 0");
    }

    public function testBuildGrid()
    {
        $grid = $this->game->getGrid();
        $this->assertEquals(count($grid[0]), 4, 'testing rows');
        $this->assertEquals(count($grid[0][1]), 4, 'testing cols');
    }

    public function testOutputGrid()
    {
        $result = $this->game->getResult();

        $this->assertEquals($result[0][0][0], '*', 'testing 0,0,0 [*]');
        $this->assertEquals($result[0][0][1], '1', 'testing 0,0,1 [1]');
        $this->assertEquals($result[0][1][0], '2', 'testing 0,1,0 [2]');
        $this->assertEquals($result[0][2][1], '*', 'testing 0,2,1 [*]');

        $this->assertEquals($result[1][0][1], '*', 'testing 1,0,1 [*]');
        $this->assertEquals($result[1][0][4], '0', 'testing 1,0,4 [0]');
        $this->assertEquals($result[1][1][0], '3', 'testing 1,1,0 [3]');
        $this->assertEquals($result[1][2][0], '1', 'testing 1,2,0 [1]');
        $this->assertEquals($result[1][2][4], '0', 'testing 1,2,4 [0]');
    }

    public function testOutputString()
    {
        $result = $this->game->getResult();
        $string = $this->game->asString($result);
        
        $expectedOutput = "Field #1:\n*100\n2210\n1*10\n1110\nField #2:\n**100\n33200\n1*100";
        $this->assertEquals($expectedOutput, $string, 'tell full');
    }
}
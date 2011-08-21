<?php

require_once '../MinesweeperFactory.php';

/**
 * Tests Minesweeper (12Meses12Katas, agosto 2011)
 *
 * @author rmhdev
 */
class MinesweeperTest extends PHPUnit_Framework_TestCase {

    public function testFactorygenerateUniqueShouldReturnMinesweeperObject(){
        $parameters = "1 1\n.";
        $minesweeper = MinesweeperFactory::generateUnique($parameters);

        $this->assertInstanceOf('Minesweeper', $minesweeper);
    }

    public function test1x1MinesweeperSizeShouldBe1x1(){
        $parameters = "1 1\n.";
        $minesweeper = MinesweeperFactory::generateUnique($parameters);

        $this->assertEquals(1, $minesweeper->getRows());
        $this->assertEquals(1, $minesweeper->getCols());
    }

    public function test2x3MinesweeperSizeShouldBe2x3(){
        $parameters = "2 3\n...\n...";
        $minesweeper = MinesweeperFactory::generateUnique($parameters);

        $this->assertEquals(2, $minesweeper->getRows());
        $this->assertEquals(3, $minesweeper->getCols());
    }

    public function testRenderRowInSafe1x1MinesweeperShouldReturnZero(){
        $parameters = "1 1\n.";
        $minesweeper = MinesweeperFactory::generateUnique($parameters);

        $this->assertSame('0', $minesweeper->renderRow(0));
    }

    public function testRenderRowInSafe3x3MinesweeperShouldReturnZeros(){
        $parameters = "3 3\n...\n...\n...";
        $minesweeper = MinesweeperFactory::generateUnique($parameters);

        $this->assertSame('000', $minesweeper->renderRow(0));
        $this->assertSame('000', $minesweeper->renderRow(1));
        $this->assertSame('000', $minesweeper->renderRow(2));
    }

    public function testRenderRowInMined1x1MinesweeperShouldReturnAsterisk(){
        $parameters = "1 1\n*";
        $minesweeper = MinesweeperFactory::generateUnique($parameters);

        $this->assertSame('*', $minesweeper->renderRow(0));
    }

    public function testRenderRowInMined3x3MinesweeperShouldReturnCorrect(){
        $parameters = "3 3\n*..\n...\n...";
        $minesweeper = MinesweeperFactory::generateUnique($parameters);

        $this->assertSame('*10', $minesweeper->renderRow(0));
        $this->assertSame('110', $minesweeper->renderRow(1));
        $this->assertSame('000', $minesweeper->renderRow(2));
    }

    public function testRenderRowInMined4x4MinesweeperShouldReturnCorrect(){
        $parameters = "4 4\n*...\n....\n.*..\n....";
        $minesweeper = MinesweeperFactory::generateUnique($parameters);

        $this->assertSame('*100', $minesweeper->renderRow(0));
        $this->assertSame('2210', $minesweeper->renderRow(1));
        $this->assertSame('1*10', $minesweeper->renderRow(2));
        $this->assertSame('1110', $minesweeper->renderRow(3));
    }


    public function testRenderFieldNameShouldReturnFieldName(){
        $parameters = "1 1\n.";
        $minesweeper = MinesweeperFactory::generateUnique($parameters);

        $this->assertEquals("Field #1:", $minesweeper->renderFieldName());
    }

    public function testRenderShouldReturnCompleteString(){
        $parameters = "1 1\n.";
        $expected = "Field #1:\n0";
        $minesweeper = MinesweeperFactory::generateUnique($parameters);

        $this->assertEquals($expected, $minesweeper->render());
    }

    //multiple minesweeper
    public function testFactorygenerateUniqueCollectionShouldReturnMinesweeperCollectionObject(){
        $parameters = "1 1\n.";
        $minesweeperCollection = MinesweeperFactory::generateCollection($parameters);

        $this->assertInstanceOf('MinesweeperCollection', $minesweeperCollection);
    }

    public function testMinesweeperCollectionCountWithUniqueMinesweeperShouldReturn1(){
        $parameters = "1 1\n.";
        $minesweeperCollection = MinesweeperFactory::generateCollection($parameters);

        $this->assertEquals(1, $minesweeperCollection->count());
    }

    public function testMinesweeperCollectionCountWithTwoMinesweepersShouldReturn2(){
        $parameters = "2 3\n...\n...\n2 3\n...\n...";
        $minesweeperCollection = MinesweeperFactory::generateCollection($parameters);

        $this->assertEquals(2, $minesweeperCollection->count());
    }

    public function testMinesweeperCollectionRenderWithTwoMinesweepersShouldReturnCorrectString(){
        $parameters = "2 3\n...\n...\n2 3\n...\n...";
        $expected = "Field #1:\n000\n000\n\nField #2:\n000\n000";
        $minesweeperCollection = MinesweeperFactory::generateCollection($parameters);

        $this->assertEquals($expected, $minesweeperCollection->render());
    }

    public function testMinesweeperCollectionRenderShouldReturnCorrectString(){
        $parameters = "2 3\n...\n...\n2 3\n...\n...";
        $expected = "Field #1:\n000\n000\n\nField #2:\n000\n000";
        $minesweeperCollection = MinesweeperFactory::generateCollection($parameters);

        $this->assertEquals($expected, $minesweeperCollection->render());
    }


    public function testMinesweeperCollectionAcceptanceTest(){
        $parameters = "4 4\n*...\n....\n.*..\n....\n3 5\n**...\n.....\n.*...\n0 0";
        $expected = "Field #1:\n*100\n2210\n1*10\n1110\n\nField #2:\n**100\n33200\n1*100";
        $minesweeperCollection = MinesweeperFactory::generateCollection($parameters);

        $this->assertEquals($expected, $minesweeperCollection->render());
    }

}

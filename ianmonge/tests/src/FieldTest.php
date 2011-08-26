<?php

require_once dirname(__FILE__) . '/../../src/Field.php';

/**
 * Test class for Field.
 */
class FieldTest extends PHPUnit_Framework_TestCase
{
    /**
     * Number of rows amb columns by default in the tests.
     */
    const ROWS_NUM = 3;
    const COLS_NUM = 5;

    /**
     * @var Field
     */
    protected $object;

    /**
     * Sets up the fixture, for example, opens a network connection.
     * This method is called before a test is executed.
     */
    protected function setUp()
    {
        $this->object = new Field( self::ROWS_NUM, self::COLS_NUM );
    }

    /**
     * Return an filled board with simple squares, without bombs.
     *
     * @param type $rowsNum
     * @param type $colsNum
     * @return array 
     */
    protected function getBoardEmpty( $rowsNum = self::ROWS_NUM, $colsNum = self::COLS_NUM )
    {
        $board = array();

        for( $row = 0; $row < $rowsNum; $row++ )
        {
            for( $col = 0; $col < $colsNum; $col++ )
            {
                $board[ $row ][ $col ] = new SquareSimple;
            }
        }
        
        return $board;
    }

    /**
     * Test the method __construct().
     */
    public function test__construct()
    {
        $this->assertAttributeEquals( self::ROWS_NUM, 'rowsNum', $this->object );
        $this->assertAttributeEquals( self::COLS_NUM, 'colsNum', $this->object );
        
        $expected = $this->getBoardEmpty();
        $this->assertAttributeEquals( $expected, 'board', $this->object );
    }

    /**
     * Test the method setSquareBomb().
     */
    public function testSetSquareBomb()
    {
        $this->object->setSquareBomb( 1, 1 );

        $expected = $this->getBoardEmpty();
        $expected[1][1] = new SquareBomb;
        $square = $expected[0][0];
        $square->incrementNumOfBombs();
        $square = $expected[0][1];
        $square->incrementNumOfBombs();
        $square = $expected[0][2];
        $square->incrementNumOfBombs();
        $square = $expected[1][0];
        $square->incrementNumOfBombs();
        $square = $expected[1][2];
        $square->incrementNumOfBombs();
        $square = $expected[2][0];
        $square->incrementNumOfBombs();
        $square = $expected[2][1];
        $square->incrementNumOfBombs();
        $square = $expected[2][2];
        $square->incrementNumOfBombs();

        $this->assertAttributeEquals( $expected, 'board', $this->object );

        $this->object->setSquareBomb( 0, 0 );

        $expected[0][0] = new SquareBomb;
        $square = $expected[0][1];
        $square->incrementNumOfBombs();
        $square = $expected[1][0];
        $square->incrementNumOfBombs();

        $this->assertAttributeEquals( $expected, 'board', $this->object );

        $this->object->setSquareBomb( 1, 2 );

        $expected[1][2] = new SquareBomb;
        $square = $expected[0][1];
        $square->incrementNumOfBombs();
        $square = $expected[0][2];
        $square->incrementNumOfBombs();
        $square = $expected[0][3];
        $square->incrementNumOfBombs();
        $square = $expected[1][3];
        $square->incrementNumOfBombs();
        $square = $expected[2][1];
        $square->incrementNumOfBombs();
        $square = $expected[2][2];
        $square->incrementNumOfBombs();
        $square = $expected[2][3];
        $square->incrementNumOfBombs();

        $this->assertAttributeEquals( $expected, 'board', $this->object );
    }

    /**
     * Test the method __toString().
     */
    public function test__toString()
    {
        $output = $this->object->__toString();

        $expected = <<<HEREDOC
00000
00000
00000

HEREDOC;
        
        $this->assertEquals( $expected, $output );

        $this->object->setSquareBomb( 0, 0 );
        $this->object->setSquareBomb( 1, 1 );
        $this->object->setSquareBomb( 1, 2 );
        $output = $this->object->__toString();

        $expected = <<<HEREDOC
*3210
2**10
12210

HEREDOC;
        
        $this->assertEquals( $expected, $output );
    }

}

?>

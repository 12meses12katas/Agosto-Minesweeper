<?php

require_once dirname(__FILE__) . '/../../src/SquareSimple.php';

/**
 * Test class for SquareSimple.
 */
class SquareSimpleTest extends PHPUnit_Framework_TestCase
{

    /**
     * @var SquareSimple
     */
    protected $object;

    /**
     * Sets up the fixture, for example, opens a network connection.
     * This method is called before a test is executed.
     */
    protected function setUp()
    {
        $this->object = new SquareSimple;
    }

    /**
     * Test the method getNumOfBombs().
     */
    public function testGetNumOfBombs()
    {
        $result     = $this->object->getNumOfBombs();
        $expected   = 0;
        
        $this->assertEquals( $result, $expected, 'There must be zero bombs.' );
    }

    /**
     * Test the method incrementNumOfBombs().
     */
    public function testIncrementNumOfBombs()
    {
        $this->object->incrementNumOfBombs();
        $result     = $this->object->getNumOfBombs();
        $expected   = 1;

        $this->assertEquals( $result, $expected, 'There must be one bomb near.' );
        
        $this->object->incrementNumOfBombs();
        $result     = $this->object->getNumOfBombs();
        $expected   = 2;

        $this->assertEquals( $result, $expected, 'There must be two bombs near.' );
        
        $this->object->incrementNumOfBombs();
        $this->object->incrementNumOfBombs();
        $this->object->incrementNumOfBombs();
        $this->object->incrementNumOfBombs();
        $this->object->incrementNumOfBombs();
        $this->object->incrementNumOfBombs();
        $result     = $this->object->getNumOfBombs();
        $expected   = 8;

        $this->assertEquals( $result, $expected, 'There must be two bombs near.' );
    }

    /**
     * Test the method __toString().
     */
    public function test__toString()
    {
        $result     = $this->object->__toString();
        $expected   = '0';

        $this->assertEquals( $result, $expected, 'The method "__toString" must return "0".' );
        
        $this->object->incrementNumOfBombs();
        $result     = $this->object->__toString();
        $expected   = '1';

        $this->assertEquals( $result, $expected, 'The method "__toString" must return "1".' );
        
        $this->object->incrementNumOfBombs();
        $this->object->incrementNumOfBombs();
        $this->object->incrementNumOfBombs();
        $this->object->incrementNumOfBombs();
        $this->object->incrementNumOfBombs();
        $this->object->incrementNumOfBombs();
        $this->object->incrementNumOfBombs();
        $result     = $this->object->__toString();
        $expected   = '8';

        $this->assertEquals( $result, $expected, 'The method "__toString" must return "8".' );
    }

}

?>

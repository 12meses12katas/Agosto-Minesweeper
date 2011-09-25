<?php
class Minesweeper
{
    private $grid = array();
    public function load($conf)
    {
        $confArray = explode("\n", $conf);
        $this->decodeConf($confArray);
    }

    private function decodeConf($conf)
    {
        $gridId = 0;
        for ($i=0; $i<count($conf); $i++) {
            list($rows, $cols) = explode(" ", $conf[$i]);
            $i++;
            $maxRow = $rows + $i -1;
            for ($row = $i; $row <= $maxRow; $row++) {
                for ($col = 1; $col <= $cols; $col++) {
                    $this->grid[$gridId][$row-$i][$col-1] = $conf[$row][$col-1];
                }
            }
            $i += $rows - 1;
            $gridId ++;
        }
    }

    public function getGrid()
    {
        return $this->grid;
    }

    public function getResult()
    {
        $out = array();
        foreach ($this->grid as $gridId => $grid) {
            foreach ($grid as $row => $cols) {
                foreach ($cols as $col => $value) {
                    $out[$gridId][$row][$col] = $this->decode($gridId, $row, $col);
                }
            }
        }
        return $out;
    }

    const MINE = '*';
    private function decode($gridId, $row, $col) {
        $value = $this->getValue($gridId, $row, $col);
        if ($value == self::MINE) {
            return self::MINE;
        } else {
            return $this->findCloseMines($gridId, $row, $col);
        }
    }

    private function getValue($gridId, $row, $col)
    {
        if (isset($this->grid[$gridId][$row]) && isset($this->grid[$gridId][$row][$col])) {
            return $this->grid[$gridId][$row][$col];
        } else {
            return 0;
        }
    }

    private function findCloseMines($gridId, $row, $col)
    {
        $mines = 0;
        $values = array(-1, 0, 1);
        foreach ($values as $rowOffset) {
            foreach ($values as $colOffset) {
                if ($this->getValue($gridId, $row + $rowOffset, $col + $colOffset) === self::MINE) {
                    $mines++;
                }
            }
        }
        return $mines;
    }

    public function asString($result)
    {
        $out = array();
        $fieldId = 0;
        foreach ($result as $gridId => $grid) {
            $fieldId++;
            $out[] = "Field #{$fieldId}:";
            foreach ($grid as $row => $cols) {
                $out[] = implode("", $cols);
            }
        }
        return implode("\n", $out);
    }
}
import unittest

EOF = "0 0"

class mine_sweeper_tests(unittest.TestCase):
    def isHeader(self, line):
        return line.count(" ") > 0

    def test_sabe_cuando_hay_un_campo_definido(self):
        fields = "1 1\n.\n0 0"

        field_count = 0
        for line in fields.split("\n"):
            if (self.isHeader(line)):
                if (EOF == line):
                    break
                field_count += 1
                height, width = map(lambda text: int(text), line.split(" "))

        self.assertEquals(1, field_count)

    def test_sabe_el_ancho_y_el_alto_de_un_campo(self):
        fields = "2 3\n...\n...\n0 0"

        field_count = width = height = 0
        for line in fields.split("\n"):
            if (self.isHeader(line)):
                if (EOF == line):
                    break
                field_count += 1
                height, width = map(lambda text: int(text), line.split(" "))

        self.assertEquals(2, height)
        self.assertEquals(3, width)

    def readTiles(self, line, tiles):
        for tile in line:
            tiles.append(tile)

    def test_guarda_las_celdas_de_un_campo(self):
        fields = "2 3\n...\n*..\n0 0"

        field_count = width = height = 0
        tiles = []
        for line in fields.split("\n"):
            if (self.isHeader(line)):
                if (EOF == line):
                    break
                field_count += 1
                height, width = map(lambda text: int(text), line.split(" "))
            else:
                self.readTiles(line, tiles)

        self.assertEquals(6, len(tiles))
        self.assertEquals("*", tiles[3])

    def test_resuelve_un_campo_de_1x1_sin_minas(self):
        fields = "1 1\n.\n0 0"

        field_count = width = height = 0
        tiles = []
        for line in fields.split("\n"):
            if (self.isHeader(line)):
                if (EOF == line):
                    break
                field_count += 1
                height, width = map(lambda text: int(text), line.split(" "))
            else:
                self.readTiles(line, tiles)

        solution = "Field #1:" + "\n"
        for y in range(0, height):
            for x in range(0, width):
                position = x + y * width
                tile = tiles[position]
                if ("." == tile):
                    tile = str(0)
                solution += tile
            solution += "\n"
        solution += "\n"
        
        exp_solution = "Field #1:\n0\n\n"
        self.assertEquals(exp_solution, solution)


        
import unittest

SAFE_TILE = "."

NEW_LINE = "\n"

EOF = "0 0"

class mine_sweeper_tests(unittest.TestCase):


    def test_sabe_cuando_hay_un_campo_definido(self):
        fields = "1 1\n.\n0 0"

        field_count, height, tiles, width = self.parse_fields(fields)

        self.assertEquals(1, field_count)

    def test_sabe_el_ancho_y_el_alto_de_un_campo(self):
        fields = "2 3\n...\n...\n0 0"

        field_count, height, tiles, width = self.parse_fields(fields)

        self.assertEquals(2, height)
        self.assertEquals(3, width)


    def test_guarda_las_celdas_de_un_campo(self):
        fields = "2 3\n...\n*..\n0 0"

        field_count, height, tiles, width = self.parse_fields(fields)

        self.assertEquals(6, len(tiles))
        self.assertEquals("*", tiles[3])

    def test_resuelve_un_campo_de_1x1_sin_minas(self):
        fields = "1 1\n.\n0 0"

        field_count, height, tiles, width = self.parse_fields(fields)

        solution = "Field #1:" + NEW_LINE
        for y in range(0, height):
            for x in range(0, width):
                position = x + y * width
                tile = tiles[position]
                if ("." == tile):
                    tile = str(0)
                solution += tile
            solution += NEW_LINE
        solution += NEW_LINE

        exp_solution = "Field #1:\n0\n\n"
        self.assertEquals(exp_solution, solution)

    def count_mines_at(self, position, tiles):
        mines = 0
        for boundary_position in range(position - 4, position + 5):
            if (boundary_position >= 0 and boundary_position < len(tiles)):
                mines += 1 if ("*" == tiles[boundary_position]) else 0
        return mines

    def reveal_tile(self, position, tiles):
        tile = tiles[position]
        if (SAFE_TILE == tile):
            tile = str(self.count_mines_at(position, tiles))
        return tile

    def get_position(self, width, x, y):
        return x + y * width

    def test_resuelve_un_campo_de_3x3_con_una_mina_en_el_medio(self):
        fields = "3 3\n...\n.*.\n...\n0 0"

        field_count, height, tiles, width = self.parse_fields(fields)

        solution = "Field #1:" + NEW_LINE
        for y in range(0, height):
            for x in range(0, width):
                position = self.get_position(width, x, y)
                solution += self.reveal_tile(position, tiles)
            solution += NEW_LINE
        solution += NEW_LINE

        exp_solution = "Field #1:\n111\n1*1\n111\n\n"
        self.assertEquals(exp_solution, solution)

    def is_header(self, line):
        return line.count(" ") > 0

    def readTiles(self, line, tiles):
        for tile in line:
            tiles.append(tile)

    def parse_fields(self, fields):
        field_count = width = height = 0
        tiles = []
        for line in fields.split("\n"):
            if (self.is_header(line)):
                if (EOF == line):
                    break
                field_count += 1
                height, width = map(lambda text: int(text), line.split(" "))
            else:
                self.readTiles(line, tiles)
        return field_count, height, tiles, width


        
package cwSkyWars;

public abstract class EnemyShip {
	
	protected String name;
	private int enemyShipId = 0;
	private int esRow;
	private int esSq;
	private boolean hasMoved = false;
	private String type;
	
	public int getEnemyShipId() {
		return this.enemyShipId;
	}

	public void setEnemyShipId(int enemyShipId) {
		this.enemyShipId = enemyShipId;
	}
	
	public boolean isHasMoved() {
		return this.hasMoved;
	}

	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getEsRow() {
		return this.esRow;
	}

	public void setEsRow(int esRow) {
		this.esRow = esRow;
	}

	public int getEsSq() {
		return this.esSq;
	}

	public void setEsSq(int esSq) {
		this.esSq = esSq;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return this.name;
	}
} // end class

//private boolean edgeRow = false;
//private boolean edgeSq = false;	
//private final int GRID_MIN_LIMIT = 0;
//private final int GRID_MAX_LIMIT = 5;

//public boolean isEdgeRow (int row) {
//row = this.getEsRow();
//if(row ==  GRID_MIN_LIMIT + 1 || row == GRID_MAX_LIMIT - 1) {
//	edgeRow = true;
//}
//return edgeRow;
//}
//
//public boolean isEdgeSq (int sq) {
//sq = this.getEsSq();
//if(sq == GRID_MIN_LIMIT + 1 || sq == GRID_MAX_LIMIT - 1 ) {
//	edgeSq = true;
//}
//return edgeSq;
//}



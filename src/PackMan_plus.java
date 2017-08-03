import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PackMan_plus extends JFrame implements KeyListener, MouseListener {

	// 27 * 21
	static char map[][] = {
			{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
			{ '#', '$', '$', '$', '$', '$', '$', '$', '$', '$', '#', '$', '$', '$', '$', '$', '$', '$', '$', '$', '#' },
			{ '#', '$', '#', '#', '#', '$', '#', '#', '#', '$', '#', '$', '#', '#', '#', '$', '#', '#', '#', '$', '#' },
			{ '#', 'N', '#', '0', '#', '$', '#', '0', '#', '$', '#', '$', '#', '0', '#', '$', '#', '0', '#', 'H', '#' },
			{ '#', '$', '#', '#', '#', '$', '#', '#', '#', '$', '#', '$', '#', '#', '#', '$', '#', '#', '#', '$', '#' },
			{ '#', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '#' },
			{ '#', '$', '#', '#', '#', '$', '#', '$', '#', '#', '#', '#', '#', '$', '#', '$', '#', '#', '#', '$', '#' },
			{ '#', '$', '#', '#', '#', '$', '#', '$', '#', '#', '#', '#', '#', '$', '#', '$', '#', '#', '#', '$', '#' },
			{ '#', '$', '$', '$', '$', '$', '#', '$', '$', '$', '#', '$', '$', '$', '#', '$', '$', '$', '$', '$', '#' },
			{ '#', '#', '#', '#', '#', '$', '#', '#', '#', '0', '#', '0', '#', '#', '#', '$', '#', '#', '#', '#', '#' },
			{ '0', '0', '0', '0', '#', '$', '#', '0', '0', '0', '0', '0', '0', '0', '#', '$', '#', '0', '0', '0', '0' },
			{ '0', '0', '0', '0', '#', '$', '#', '0', '#', '#', '0', '#', '#', '0', '#', '$', '#', '0', '0', '0', '0' },
			{ '#', '#', '#', '#', '#', '$', '#', '0', '#', '0', '0', '0', '#', '0', '#', '$', '#', '#', '#', '#', '#' },
			{ '@', '@', '@', '0', '0', '$', '0', '0', '#', '0', '0', '0', '#', '0', '0', '$', '0', '0', '@', '@', '@' },
			{ '#', '#', '#', '#', '#', '$', '#', '0', '#', '#', '#', '#', '#', '0', '#', '$', '#', '#', '#', '#', '#' },
			{ '0', '0', '0', '0', '#', '$', '#', '0', '0', '0', '0', '0', '0', '0', '#', '$', '#', '0', '0', '0', '0' },
			{ '0', '0', '0', '0', '#', '$', '#', '0', '#', '#', '#', '#', '#', '0', '#', '$', '#', '0', '0', '0', '0' },
			{ '#', '#', '#', '#', '#', '$', '#', '0', '#', '#', '#', '#', '#', '0', '#', '$', '#', '#', '#', '#', '#' },
			{ '#', '$', '$', '$', '$', '$', '$', '$', '$', '$', '#', '$', '$', '$', '$', '$', '$', '$', '$', '$', '#' },
			{ '#', '$', '#', '#', '#', '$', '#', '#', '#', '$', '#', '$', '#', '#', '#', '$', '#', '#', '#', '$', '#' },
			{ '#', 'A', '$', '$', '#', '$', '$', '$', '$', '$', '0', '$', '$', '$', '$', '$', '#', '$', '$', 'S', '#' },
			{ '#', '#', '#', '$', '#', '$', '#', '$', '#', '#', '#', '#', '#', '$', '#', '$', '#', '$', '#', '#', '#' },
			{ '#', '#', '#', '$', '#', '$', '#', '$', '#', '#', '#', '#', '#', '$', '#', '$', '#', '$', '#', '#', '#' },
			{ '#', '$', '$', '$', '$', '$', '#', '$', '$', '$', '#', '$', '$', '$', '#', '$', '$', '$', '$', '$', '#' },
			{ '#', '$', '#', '#', '#', '#', '#', '#', '#', '$', '#', '$', '#', '#', '#', '#', '#', '#', '#', '$', '#' },
			{ '#', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '$', '#' },
			{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',
					'#' } };

	Image backgroundimg, TmpImage;
	ImageIcon tmpimg, tmpimg2;

	static int Me_x;
	static int Me_y;
	static int Me_px;
	static int Me_py;
	static int PWidth;
	static int PHeight;
	static int TmpPWidth;
	static int TmpPHeight;
	static int PressKey;
	static int PSpace;
	static int PSpeed;
	static PMPanel pPM;
	static int MainTime;
	static int TotalScore;
	static int MaxFWidth = 435;
	static int MaxFHeight = 575;
	static int MaxMWidth = 300;
	static int CntCoin;
	static int PLife;
	static int GhostDir[];
	static int GhostKind;
	static int G_x[];
	static int G_y[];
	static int G_px[];
	static int G_py[];
	static int GSpace;
	static int GSpeed[];
	static int DirMax;
	static int DirMin;
	static int DirTmp[];
	static int GhostDirChoice[];
	static boolean GhostLeftOk[];
	static boolean GhostRightOk[];
	static boolean GhostUpOk[];
	static boolean GhostDownOk[];
	static int G_M;
	static int SuperPower;
	static int PTime;
	static int TmpPSTime = 0;
	static int TmpPSTime2 = 0;
	static int TmpPSpeed;
	static boolean GameOver;
	static boolean GameStart;
	static boolean GameReady, GameGo;
	static int H, M, S;
	static int TotalCoin;
	static boolean VictoryGame, LoseGame;
	static int x, y;
	static int GameLevel;
	static int SetGSpeed;
	static boolean GamePause;

	public static void TEST() {
		// System.out.println(Me_y+" , "+Me_x+" , "+Me_py+" , "+Me_px+ " ,
		// "+MainTime+" , "+CntCoin+" , Dir : "+" , "+GhostDir[0] );
		// System.out.println(x+" , "+y);
		// System.out.println(TotalCoin+" , "+CntCoin);
	}

	public static void ValueInitialize() {

		Me_x = 10;
		Me_y = 20;
		Me_px = 0;
		Me_py = 0;
		PWidth = 30;
		PHeight = 30;
		PressKey = 0;
		PSpace = 20;

		if (GameStart == false) {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] == '*') {
						map[i][j] = '$';
					}
					if (map[i][j] == 'a') {
						map[i][j] = 'A';
					}
					if (map[i][j] == 's') {
						map[i][j] = 'S';
					}
					if (map[i][j] == 'n') {
						map[i][j] = 'N';
					}
					if (map[i][j] == 'h') {
						map[i][j] = 'H';
					}
				}
			}
			SuperPower = 0;
			CntCoin = 0;
			TotalScore = 0;
			MainTime = 0;
			PSpeed = 10;
		}

		GSpeed = new int[GhostKind];
		GhostDir = new int[GhostKind];
		G_x = new int[GhostKind];
		G_y = new int[GhostKind];
		G_px = new int[GhostKind];
		G_py = new int[GhostKind];
		GSpace = 20;

		DirMax = 3;
		DirMin = 0;
		DirTmp = new int[GhostKind];
		GhostLeftOk = new boolean[GhostKind];
		GhostUpOk = new boolean[GhostKind];
		GhostRightOk = new boolean[GhostKind];
		GhostDownOk = new boolean[GhostKind];
		GhostDirChoice = new int[4];

		for (int i = 0; i < GhostKind; i++) {
			int k = i % 4;
			G_x[i] = 9 + k;
			G_y[i] = 13;
			G_px[i] = G_x[i] * GSpace;
			G_py[i] = 5 + G_y[i] * GSpace;
			GSpeed[i] = SetGSpeed;
			GhostLeftOk[i] = true;
			GhostUpOk[i] = true;
			GhostRightOk[i] = true;
			GhostDownOk[i] = true;
			DirTmp[i] = (int) (Math.random() * (DirMax - DirMin + 1)) + DirMin;
		}

		Me_px = Me_x * PSpace;
		Me_py = 5 + Me_y * PSpace;
		G_M = 5;
		PTime = 0;
	}

	public PackMan_plus() {
		super("PacMan_Puls by BNItech");
		// ValueInitialize();
		Container ctp = getContentPane();

		pPM = new PMPanel();

		ctp.setLayout(new BorderLayout());

		ctp.add(pPM, BorderLayout.CENTER);

		setLocation(300, 50);
		setSize(MaxFWidth + MaxMWidth, MaxFHeight);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		addKeyListener(this);
		addMouseListener(this);
	}

	public static void main(String[] args) {

		PackMan_plus fPM = new PackMan_plus();

		fPM.setVisible(true);
		fPM.setResizable(false);

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == '$') {
					TotalCoin++;
				}
			}
		}

		while (true) {
			pPM.repaint();
			// if(GamePause==false){

			if (GameStart == false) {
				pPM.repaint();
			} else {

				if (LoseGame == true) {
					ValueInitialize();
					GameOver = false;
					pPM.repaint();

				}
				if (VictoryGame == true) {
					ValueInitialize();
					GameOver = false;
					pPM.repaint();

				}
				try {

					// TEST();
					MainTime++;
					if (GameOver == false) {
						PlayerMove();
						GhostMove();
						Score();
						if (GameReady == true) {
							Thread.sleep(4000);
							GameReady = false;
							GameGo = true;
						}

						Thread.sleep(20);
					} else {
						if (PLife == -1) {
							LoseGame = true;
						} else {
							ValueInitialize();
							pPM.repaint();
							GameReady = true;
							GameOver = false;
						}
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				pPM.repaint();
				if (MainTime == 1000)
					MainTime = 0;
			}
			// }
		} // end while
	}

	@Override
	public void keyPressed(KeyEvent kevt) {
		int ckey;
		ckey = kevt.getKeyCode();
		if (ckey == 38) {
			PressKey = 1; // UP
		}
		if (ckey == 40) {
			PressKey = 3; // Down
		}
		if (ckey == 37) {
			PressKey = 0; // Left
		}
		if (ckey == 39) {
			PressKey = 2; // Right
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent m) {
		// TODO Auto-generated method stub
		x = m.getX();
		y = m.getY();
		if (LoseGame == true || VictoryGame == true) {
			if (x >= MaxFWidth + 25 && x <= MaxFWidth + 25 + 140 && y >= this.getHeight() - 87
					&& y <= this.getHeight() - 87 + 45) {
				GameStart = false;
				LoseGame = false;
				VictoryGame = false;
				return;
			}
		}

		if (GameStart == false) {
			if (x >= MaxFWidth + 25 && x <= MaxFWidth + 25 + 150 && y >= this.getHeight() - 87
					&& y <= this.getHeight() - 87 + 45) {
				if (GameLevel == 0) {
					GhostKind = 4;
					SetGSpeed = 20;
					PLife = 4;
				} else if (GameLevel == 1) {
					GhostKind = 5;
					SetGSpeed = 15;
					PLife = 3;
				} else if (GameLevel == 2) {
					GhostKind = 6;
					SetGSpeed = 10;
					PLife = 2;
				}
				ValueInitialize();
				MainTime = 0;
				GameReady = true;
				GameStart = true;
			}
			if (x >= MaxFWidth + 190 && x <= MaxFWidth + 210 && y >= this.getHeight() - 70
					&& y <= this.getHeight() - 50) {
				if (GameLevel == 1) {
					GameLevel = 0;
				} else if (GameLevel == 2) {
					GameLevel = 1;
				}
			}
			if (x >= MaxFWidth + 250 && x <= MaxFWidth + 270 && y >= this.getHeight() - 70
					&& y <= this.getHeight() - 50) {
				if (GameLevel == 0) {
					GameLevel = 1;
				} else if (GameLevel == 1) {
					GameLevel = 2;
				}
			}
		} else {
			if (LoseGame == false && VictoryGame == false) {
				if (x >= MaxFWidth + 25 && x <= MaxFWidth + 25 + 150 && y >= this.getHeight() - 87
						&& y <= this.getHeight() - 87 + 45) {
					if (GamePause == true) {
						GamePause = false;
					}
					if (GamePause == false) {
						GamePause = true;
					}
					return;
				}
			}
		}
		// TEST();
	}

	public static void PlayerMove() {
		TEST();
		if (SuperPower == 2) {
			if (TmpPSTime == 0) {
				TmpPSpeed = PSpeed;
				PSpeed = 3;
			}
			TmpPSTime++;
			if (TmpPSTime == 400) {
				SuperPower = 0;
				PSpeed = TmpPSpeed;
				TmpPSTime = 0;
			}
		}

		if (SuperPower == 3) {
			if (TmpPSTime == 0) {
				TmpPWidth = PWidth;
				TmpPHeight = PHeight;
				PWidth = 40;
				PHeight = 40;
				TmpPSpeed = PSpeed;
				PSpeed = 7;
			}
			TmpPSTime++;
			if (TmpPSTime == 500) {
				SuperPower = 0;
				TmpPSTime = 0;
				PWidth = TmpPWidth;
				PHeight = TmpPHeight;
				PSpeed = TmpPSpeed;
			}
		}

		if (SuperPower == 4) {
			TmpPSTime++;
			if (TmpPSTime == 500) {
				SuperPower = 0;
				TmpPSTime = 0;
			}
		}

		if (MainTime % (PSpeed / 3) == 0) {
			if (PTime == 3)
				PTime = 0;
			PTime++;
		}
		if (MainTime % PSpeed == 0) {

			switch (PressKey) {
			case 0:
				if (Me_x < 0)
					Me_x = 0;
				if (map[Me_y][Me_x - 1] != '#')
					Me_x--;
				break;
			case 1:
				if (Me_y < 0)
					Me_y = 0;
				if (map[Me_y - 1][Me_x] != '#')
					Me_y--;
				break;
			case 2:
				if (Me_x > 21)
					Me_x = 21;
				if (map[Me_y][Me_x + 1] != '#')
					Me_x++;
				break;
			case 3:
				if (Me_y > 27)
					Me_y = 27;
				if (map[Me_y + 1][Me_x] != '#')
					Me_y++;
				break;
			default:
				break;
			}

			Me_px = Me_x * PSpace;
			Me_py = 5 + Me_y * PSpace;

			for (int i = 0; i < GhostKind; i++) {
				if (Me_x == G_x[i] && Me_y == G_y[i]) {
					if (SuperPower == 3) {
						G_x[i] = 10;
						G_y[i] = 13;
						TotalScore += 200;
					} else if (SuperPower == 4) {

					} else {
						GameOver = true;
						PLife--;
					}
				}
			}

			if (map[Me_y][Me_x] == '@') {
				if (PressKey == 0) {
					Me_x = 18;
				}
				if (PressKey == 2) {
					Me_x = 2;
				}
			}

			if (map[Me_y][Me_x] == 'A') {
				if (SuperPower == 0) {
					map[Me_y][Me_x] = 'a';
					SuperPower = 1;
				}
			}
			if (map[Me_y][Me_x] == 'S') {
				if (SuperPower == 0) {
					map[Me_y][Me_x] = 's';
					SuperPower = 2;
				}
			}
			if (map[Me_y][Me_x] == 'N') {
				if (SuperPower == 0) {
					map[Me_y][Me_x] = 'n';
					SuperPower = 3;
				}
			}
			if (map[Me_y][Me_x] == 'H') {
				if (SuperPower == 0) {
					map[Me_y][Me_x] = 'h';
					SuperPower = 4;
					PLife++;
				}
			}
		}
	}

	public static void GhostMove() {

		for (int i = 0; i < GhostKind; i++) {

			if (map[G_y[i]][G_x[i] - 1] != '#') { // Left
				if (G_x[i] - Me_x < G_M && G_x[i] > Me_x)
					GhostLeftOk[i] = true;
				else {
					if (GhostDir[i] == 2)
						GhostLeftOk[i] = false;
					else
						GhostLeftOk[i] = true;
				}
			} else
				GhostLeftOk[i] = false;

			if (map[G_y[i] - 1][G_x[i]] != '#') {
				if (G_y[i] - Me_y < G_M && G_y[i] > Me_y)
					GhostUpOk[i] = true;
				else {
					if (GhostDir[i] == 3)
						GhostUpOk[i] = false;
					else
						GhostUpOk[i] = true;
				}
			} else
				GhostUpOk[i] = false;

			if (map[G_y[i]][G_x[i] + 1] != '#') {
				if (G_x[i] - Me_x > -G_M && G_x[i] < Me_x)
					GhostRightOk[i] = true;
				else {
					if (GhostDir[i] == 0)
						GhostRightOk[i] = false;
					else
						GhostRightOk[i] = true;
				}
			} else
				GhostRightOk[i] = false;

			if (map[G_y[i] + 1][G_x[i]] != '#') {
				if (G_y[i] - Me_y > -G_M && G_y[i] < Me_y)
					GhostDownOk[i] = true;
				else {
					if (GhostDir[i] == 1)
						GhostDownOk[i] = false;
					else
						GhostDownOk[i] = true;
				}
			} else
				GhostDownOk[i] = false;

			int Rand = 0;
			if (GhostLeftOk[i] == true) {
				GhostDirChoice[Rand] = 0;
				Rand++;
			}
			if (GhostUpOk[i] == true) {
				GhostDirChoice[Rand] = 1;
				Rand++;
			}
			if (GhostRightOk[i] == true) {
				GhostDirChoice[Rand] = 2;
				Rand++;
			}
			if (GhostDownOk[i] == true) {
				GhostDirChoice[Rand] = 3;
				Rand++;
			}

			Rand = (int) (Math.random() * ((Rand - 1) - DirMin + 1)) + DirMin;
			GhostDir[i] = GhostDirChoice[Rand];

			if (MainTime % GSpeed[i] == 0 || MainTime % GSpeed[i] == GSpeed[i] / 2) {
				TEST();

				switch (GhostDir[i]) {
				case 0:
					if (G_x[i] > 0)
						G_x[i]--;
					else
						G_x[i] = 1;
					break;
				case 1:
					if (G_y[i] > 0)
						G_y[i]--;
					else
						G_y[i] = 1;
					break;
				case 2:
					if (G_x[i] < 20)
						G_x[i]++;
					else
						G_x[i] = 19;
					break;
				case 3:
					if (G_y[i] < 26)
						G_y[i]++;
					else
						G_y[i] = 19;
					break;
				default:
					break;
				}

				G_px[i] = G_x[i] * GSpace;
				G_py[i] = 5 + G_y[i] * GSpace;
				if (map[G_y[i]][G_x[i]] == '@') {
					if (GhostDir[i] == 0) {
						G_x[i] = 18;
					}
					if (GhostDir[i] == 2) {
						G_x[i] = 2;
					}
				}
			}
		}
	}

	public static void Score() {
		if (SuperPower == 1) {
			TmpPSTime++;
			if (map[Me_y - 1][Me_x] == '$') {
				map[Me_y - 1][Me_x] = '*';
				TotalScore += 10;
				CntCoin++;
			}
			if (map[Me_y][Me_x - 1] == '$') {
				map[Me_y][Me_x - 1] = '*';
				TotalScore += 10;
				CntCoin++;
			}
			if (map[Me_y + 1][Me_x] == '$') {
				map[Me_y + 1][Me_x] = '*';
				TotalScore += 10;
				CntCoin++;
			}
			if (map[Me_y][Me_x + 1] == '$') {
				map[Me_y][Me_x + 1] = '*';
				TotalScore += 10;
				CntCoin++;
			}
			if (Me_x - 2 != -1 && Me_y - 2 != -1) {
				if (map[Me_y - 2][Me_x] == '$') {
					map[Me_y - 2][Me_x] = '*';
					TotalScore += 10;
					CntCoin++;
				}
				if (map[Me_y][Me_x - 2] == '$') {
					map[Me_y][Me_x - 2] = '*';
					TotalScore += 10;
					CntCoin++;
				}
			}
			if (Me_x + 2 != 21 && Me_y + 2 != 27) {
				if (map[Me_y + 2][Me_x] == '$') {
					map[Me_y + 2][Me_x] = '*';
					TotalScore += 10;
					CntCoin++;
				}
				if (map[Me_y][Me_x + 2] == '$') {
					map[Me_y][Me_x + 2] = '*';
					TotalScore += 10;
					CntCoin++;
				}
			}
			if (map[Me_y][Me_x] == '$') {
				map[Me_y][Me_x] = '*';
				TotalScore += 10;
				CntCoin++;
			}
			if (TmpPSTime == 500) {
				SuperPower = 0;
				TmpPSTime = 0;
			}
		} else {
			if (map[Me_y][Me_x] == '$') {
				map[Me_y][Me_x] = '*';
				TotalScore += 10;
				CntCoin++;
			}
		}
		if (TotalCoin == CntCoin) {
			VictoryGame = true;
		}
	}

	class PMPanel extends JPanel {

		public void paintComponent(Graphics g) {

			tmpimg = new ImageIcon("./imgs/bgimg.jpg");
			backgroundimg = tmpimg.getImage();
			g.drawImage(backgroundimg, 0, 0, MaxFWidth, this.getHeight(), this);

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] == '$') {
						g.setColor(Color.YELLOW);
						g.fillOval(10 + (j * 20), 15 + (i * 20), 5, 5);
					}

					if (map[i][j] == 'A') {
						tmpimg2 = new ImageIcon("./imgs/apple.png");
						TmpImage = tmpimg2.getImage();
						g.drawImage(TmpImage, 10 + (j * 20) - 5, 15 + (i * 20) - 10, 25, 25, this);
					}
					if (map[i][j] == 'S') {
						tmpimg2 = new ImageIcon("./imgs/shoes.png");
						TmpImage = tmpimg2.getImage();
						g.drawImage(TmpImage, 10 + (j * 20) - 10, 15 + (i * 20) - 10, 30, 25, this);
					}
					if (map[i][j] == 'N') {
						tmpimg2 = new ImageIcon("./imgs/android.png");
						TmpImage = tmpimg2.getImage();
						g.drawImage(TmpImage, 10 + (j * 20) - 10, 15 + (i * 20) - 10, 30, 25, this);
					}
					if (map[i][j] == 'H') {
						tmpimg2 = new ImageIcon("./imgs/heart.png");
						TmpImage = tmpimg2.getImage();
						g.drawImage(TmpImage, 10 + (j * 20) - 10, 15 + (i * 20) - 10, 30, 25, this);
					}
				}
			}
			if (SuperPower == 0) {
				g.setColor(Color.YELLOW);
			} else if (SuperPower == 1) {
				g.setColor(new Color(240, 86, 0));
			} else if (SuperPower == 2) {
				g.setColor(new Color(47, 97, 215));
			} else if (SuperPower == 3) {
				g.setColor(new Color(179, 224, 17));
			} else if (SuperPower == 4) {
				g.setColor(new Color(255, 128, 255));
			}

			if (LoseGame == false && VictoryGame == false) {
				if (PressKey == 0) {
					if (PTime % 3 == 0) {
						g.fillArc(Me_px, Me_py, PWidth, PHeight, 230, 270);
					} else if (PTime % 3 == 1) {
						g.fillArc(Me_px, Me_py, PWidth, PHeight, 210, 310);
					} else if (PTime % 3 == 2) {
						g.fillArc(Me_px, Me_py, PWidth, PHeight, 185, 355);
					}
				} else if (PressKey == 1) {
					if (PTime % 3 == 0) {
						g.fillArc(Me_px, Me_py, PWidth, PHeight, 140, 270);
					} else if (PTime % 3 == 1) {
						g.fillArc(Me_px, Me_py, PWidth, PHeight, 120, 310);
					} else if (PTime % 3 == 2) {
						g.fillArc(Me_px, Me_py, PWidth, PHeight, 95, 355);
					}
				} else if (PressKey == 2) {
					if (PTime % 3 == 0) {
						g.fillArc(Me_px, Me_py, PWidth, PHeight, 40, 270);
					} else if (PTime % 3 == 1) {
						g.fillArc(Me_px, Me_py, PWidth, PHeight, 20, 310);
					} else if (PTime % 3 == 2) {
						g.fillArc(Me_px, Me_py, PWidth, PHeight, 5, 355);
					}
				} else if (PressKey == 3) {
					if (PTime % 3 == 0) {
						g.fillArc(Me_px, Me_py, PWidth, PHeight, 310, 270);
					} else if (PTime % 3 == 1) {
						g.fillArc(Me_px, Me_py, PWidth, PHeight, 290, 310);
					} else if (PTime % 3 == 2) {
						g.fillArc(Me_px, Me_py, PWidth, PHeight, 265, 355);
					}
				}
				if (SuperPower == 3) {
					for (int i = 0; i < GhostKind; i++) {
						tmpimg2 = new ImageIcon("./imgs/scaredghost.gif");
						TmpImage = tmpimg2.getImage();
						g.drawImage(TmpImage, G_px[i], G_py[i], 25, 25, this);
					}
				} else {
					for (int i = 0; i < GhostKind; i++) {
						tmpimg2 = new ImageIcon("./imgs/ghost" + i + ".png");
						TmpImage = tmpimg2.getImage();
						g.drawImage(TmpImage, G_px[i], G_py[i], 25, 25, this);
					}
				}

			}

			if (GameReady == true) {
				tmpimg2 = new ImageIcon("./imgs/Ready.png");
				TmpImage = tmpimg2.getImage();
				g.drawImage(TmpImage, 10 * 20 - 30, 15 * 20 + 3, 100, 30, this);
			}
			if (GameGo == true) {
				tmpimg2 = new ImageIcon("./imgs/GO.png");
				TmpImage = tmpimg2.getImage();
				g.drawImage(TmpImage, 10 * 20 - 33, 15 * 20 + 3, 100, 30, this);
				TmpPSTime2++;
				if (TmpPSTime2 == 100) {
					GameGo = false;
					TmpPSTime2 = 0;
				}
			}
			if (LoseGame == true) {
				tmpimg2 = new ImageIcon("./imgs/Lose.png");
				TmpImage = tmpimg2.getImage();
				g.drawImage(TmpImage, 10 * 20 - 30, 15 * 20 + 3, 100, 30, this);
			}
			if (VictoryGame == true) {
				tmpimg2 = new ImageIcon("./imgs/Victory.png");
				TmpImage = tmpimg2.getImage();
				g.drawImage(TmpImage, 10 * 20 - 30, 15 * 20 + 3, 100, 30, this);
			}

			// 오른쪽 점수창

			g.setColor(new Color(5, 5, 5));
			g.fillRect(MaxFWidth, 0, MaxMWidth, MaxFHeight);

			Font FntTitle;
			FntTitle = new Font("Berlin Sans FB Demi", Font.PLAIN, 40);
			g.setFont(FntTitle);
			g.setColor(Color.YELLOW);
			g.drawString("PackMan_Plus", MaxFWidth + 5, 100);

			Font FntScore;
			FntScore = new Font("AR DESTINE", Font.PLAIN, 30);
			g.setFont(FntScore);
			g.setColor(Color.RED);
			g.drawString("SCORE : " + TotalScore, MaxFWidth + 15, 200);

			g.setColor(Color.YELLOW);
			Font FntTime;
			FntTime = new Font("HY엽서L", Font.BOLD, 20);
			g.setFont(FntTime);
			if (MainTime % 50 == 0 && MainTime > 60) {
				S++;
				if (S == 60) {
					S = 0;
					M++;
				}
				if (M == 60) {
					M = 0;
					H++;
				}
			}
			String StrTime = H + " 시 " + M + " 분 " + S + " 초";
			g.drawString(StrTime, MaxFWidth + 55, 370);

			if (LoseGame == true || VictoryGame == true) {
				g.setColor(Color.GREEN);
				g.drawRoundRect(MaxFWidth + 25, this.getHeight() - 87, 140, 45, 40, 40);

				Font FntBtnLose;
				FntBtnLose = new Font("AR DELANEY", Font.PLAIN, 30);
				g.setFont(FntBtnLose);
				g.drawString("REGAME", MaxFWidth + 35, this.getHeight() - 55);
			}

			if (GameStart == false) {

				tmpimg = new ImageIcon("./imgs/start.png");
				backgroundimg = tmpimg.getImage();
				g.drawImage(backgroundimg, 0, 0, MaxFWidth, this.getHeight(), this);

				g.setColor(Color.GREEN);
				g.drawRoundRect(MaxFWidth + 25, this.getHeight() - 87, 150, 45, 40, 40);

				Font FntBtnS;
				FntBtnS = new Font("AR DELANEY", Font.PLAIN, 30);
				g.setFont(FntBtnS);
				g.drawString("S T A R T", MaxFWidth + 35, this.getHeight() - 55);

				Font FntBtnL;
				FntBtnL = new Font("HY태백B", Font.PLAIN, 20);
				g.setColor(Color.MAGENTA);
				g.setFont(FntBtnL);
				g.drawString("난이도", MaxFWidth + 200, this.getHeight() - 75);

				if (GameLevel == 0) {
					Font FntBtn0;
					FntBtn0 = new Font("HY태백B", Font.PLAIN, 20);
					g.setFont(FntBtn0);
					g.setColor(Color.LIGHT_GRAY);
					g.drawString("하", MaxFWidth + 220, this.getHeight() - 50);
					g.setColor(Color.MAGENTA);
					g.drawString("▶", MaxFWidth + 250, this.getHeight() - 50);
				}
				if (GameLevel == 1) {
					Font FntBtn0;
					FntBtn0 = new Font("HY태백B", Font.PLAIN, 20);
					g.setFont(FntBtn0);
					g.drawString("◀", MaxFWidth + 190, this.getHeight() - 50);
					g.setColor(Color.CYAN);
					g.drawString("중", MaxFWidth + 220, this.getHeight() - 50);
					g.setColor(Color.MAGENTA);
					g.drawString("▶", MaxFWidth + 250, this.getHeight() - 50);
				}
				if (GameLevel == 2) {
					Font FntBtn0;
					FntBtn0 = new Font("HY태백B", Font.PLAIN, 20);
					g.setFont(FntBtn0);
					g.drawString("◀", MaxFWidth + 190, this.getHeight() - 50);
					g.setColor(Color.ORANGE);
					g.drawString("상", MaxFWidth + 220, this.getHeight() - 50);
				}
			} else {
				// if(LoseGame==false && VictoryGame==false){
				// if(GamePause==false){
				// g.setColor(Color.GREEN);
				// g.drawRoundRect(MaxFWidth+25, this.getHeight()-87, 150, 45,
				// 40, 40);
				//
				// Font FntBtnLose;
				// FntBtnLose = new Font("AR DELANEY",Font.PLAIN,30);
				// g.setFont(FntBtnLose);
				// g.drawString("S T O P", MaxFWidth+45, this.getHeight()-55);
				// }else{
				// g.setColor(Color.GREEN);
				// g.drawRoundRect(MaxFWidth+25, this.getHeight()-87, 150, 45,
				// 40, 40);
				//
				// Font FntBtnLose;
				// FntBtnLose = new Font("AR DELANEY",Font.PLAIN,30);
				// g.setFont(FntBtnLose);
				// g.drawString("P L A Y", MaxFWidth+45, this.getHeight()-55);
				// }
				// }
			}

			if (SuperPower == 0) {
				g.setColor(Color.YELLOW);
				Font FntSP0;
				FntSP0 = new Font("HY엽서L", Font.BOLD, 15);
				g.setFont(FntSP0);
				String StrSP0 = "SuperPower : 없음";
				g.drawString(StrSP0, MaxFWidth + 15, 250);
			} else if (SuperPower == 1) {
				g.setColor(new Color(240, 86, 0));
				Font FntSP1;
				FntSP1 = new Font("HY엽서L", Font.BOLD, 15);
				g.setFont(FntSP1);
				String StrSP1 = "SuperPower : 천리안 사과";
				g.drawString(StrSP1, MaxFWidth + 15, 250);
				StrSP1 = "효과 : 10초 동안 2걸음 밖에 있는 ";
				g.drawString(StrSP1, MaxFWidth + 15, 290);
				StrSP1 = "      코인 까지 먹을 수 있게 되었다 ";
				g.drawString(StrSP1, MaxFWidth + 15, 310);
			} else if (SuperPower == 2) {
				g.setColor(new Color(47, 97, 215));
				Font FntSP2;
				FntSP2 = new Font("HY엽서L", Font.BOLD, 15);
				g.setFont(FntSP2);
				String StrSP2 = "SuperPower : 스피드 UP 신발";
				g.drawString(StrSP2, MaxFWidth + 15, 250);
				StrSP2 = "효과 : 8초 동안 스피드가 2배  ";
				g.drawString(StrSP2, MaxFWidth + 15, 290);
				StrSP2 = "                  이상으로  빨라진다. ";
				g.drawString(StrSP2, MaxFWidth + 15, 310);
			} else if (SuperPower == 3) {
				g.setColor(new Color(179, 224, 17));
				Font FntSP3;
				FntSP3 = new Font("HY엽서L", Font.BOLD, 15);
				g.setFont(FntSP3);
				String StrSP3 = "SuperPower : 파워 UP 장난감";
				g.drawString(StrSP3, MaxFWidth + 15, 250);
				StrSP3 = "효과 : 10초 동안 몸집과 스피드가 ";
				g.drawString(StrSP3, MaxFWidth + 15, 290);
				StrSP3 = "           1.5배 씩 커지고 빨라지고 ";
				g.drawString(StrSP3, MaxFWidth + 15, 310);
				StrSP3 = "           몬스터를 잡을 수 있게 된다. ";
				g.drawString(StrSP3, MaxFWidth + 15, 330);
			} else if (SuperPower == 4) {
				g.setColor(new Color(255, 128, 255));
				Font FntSP4;
				FntSP4 = new Font("HY엽서L", Font.BOLD, 15);
				g.setFont(FntSP4);
				String StrSP4 = "SuperPower : 목숨 증가 하트";
				g.drawString(StrSP4, MaxFWidth + 15, 250);
				StrSP4 = "효과 : 목숨이 한개 늘어나고 10초";
				g.drawString(StrSP4, MaxFWidth + 15, 290);
				StrSP4 = "       동안 죽지않는 무적 상태가 된다";
				g.drawString(StrSP4, MaxFWidth + 15, 310);
			}
			if (GameStart == true) {
				int LifeSpace = 20;
				for (int i = 0; i < PLife; i++) {
					if (PTime % 3 == 0) {
						g.fillArc(MaxFWidth + LifeSpace, this.getHeight() - 150, PWidth, PHeight, 230, 270);
					} else if (PTime % 3 == 1) {
						g.fillArc(MaxFWidth + LifeSpace, this.getHeight() - 150, PWidth, PHeight, 210, 310);
					} else if (PTime % 3 == 2) {
						g.fillArc(MaxFWidth + LifeSpace, this.getHeight() - 150, PWidth, PHeight, 185, 355);
					}
					LifeSpace += 50;
				}
			}
		}
	}

}

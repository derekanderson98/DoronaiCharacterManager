This project was intended as a character sheet manager for Doronai Nui, a TTRPG created by fans of Lego's Bionicle theme.

The TTRPG can be found here: https://www.redstargames.org/doronai-nui

This project was chosen because the Doronai Nui system is highly modular.
This project was ultimately scrapped due to the announcement of major changes to how playable characters worked.

Lessons learned in this project
-How to utilize a file picker to open and save files
-What Java Swing is and how to use it

Problems with this project
-There is far too much logic in the model layer. These classes should contain information. The functions calculating values should be in the control layer.
-There is insufficient unit testing, partially due to the issues with the model layer.
-While useful for file pickers, Swing is a very limited frontend framework, and this project would be better suited by utilizing a newer and more versatile system.